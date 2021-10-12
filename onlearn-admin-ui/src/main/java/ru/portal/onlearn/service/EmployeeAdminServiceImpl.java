package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.portal.onlearn.controller.DTO.EmployeeAdminDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.model.Picture;
import ru.portal.onlearn.model.User;
import ru.portal.onlearn.repo.EmployeeRepository;
import ru.portal.onlearn.repo.UserRepository;
import ru.portal.onlearn.repo.specification.EmployeeSpecification;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeAdminServiceImpl implements EmployeeAdminService {

    private final EmployeeRepository employeeRepository;
    private final PictureService pictureService;
    private final UserRepository userRepository;

    public EmployeeAdminServiceImpl(EmployeeRepository employeeRepository, PictureService pictureService, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.pictureService = pictureService;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<EmployeeAdminDTO> findEmployeeById(Long id){
        return employeeRepository.findById(id)
                .map(employee -> EmployeeAdminService.mapToAdminEmployeeDTO(employee));
    }

    @Override
    public List<EmployeeAdminDTO> findAllEmployee(){
        return employeeRepository.findAll()
                .stream()
                .map(employee -> new EmployeeAdminDTO(employee))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<EmployeeAdminDTO> findByFilter(String surname, Integer page, Integer size){
        Specification<Employee> spec = Specification.where(null);
        if (surname != null){
            spec = spec.and(EmployeeSpecification.bySurname(surname));
        }

        Page<Long> ids = employeeRepository.findAll(PageRequest.of(page - 1, size))
                .map(Employee::getId);

        List<EmployeeAdminDTO> allByIds = employeeRepository.findAll().stream()
                .map(employee -> EmployeeAdminService.mapToAdminEmployeeDTO(employee))
                .collect(Collectors.toList());
        return new PageImpl<>(allByIds, PageRequest.of(page -1, size), ids.getTotalElements());
    }

    @Override
    @Transactional
    public void saveEmployee (EmployeeAdminDTO employeeAdminDTO) throws IOException {

        Employee employee;
        if (employeeAdminDTO.getId() != null) employee = employeeRepository.findById(employeeAdminDTO.getId())
                .orElseThrow(NotFoundException::new);
        else employee = new Employee();
        employee.setId(employeeAdminDTO.getId());
        employee.setName(employeeAdminDTO.getName());
        employee.setSurname(employeeAdminDTO.getSurname());
        employee.setMiddleName(employeeAdminDTO.getMiddleName());
        employee.setDateOfBirth(employeeAdminDTO.getDateOfBirth());
        employee.setSex(employeeAdminDTO.getSex());
        employee.setEmail(employeeAdminDTO.getEmail());
        employee.setPhoneNumber(employeeAdminDTO.getPhoneNumber());
        employee.setBio(employeeAdminDTO.getBio());
        employee.setUser(employeeAdminDTO.getUser());
        employee.setDepartment(employeeAdminDTO.getDepartment());
        if (employeeAdminDTO.getNewPictures() != null){
            for (MultipartFile newPicture : employeeAdminDTO.getNewPictures()){
                if (employee.getPictures() == null){
                    employee.setPictures(new ArrayList<>());
                }
                employee.getPictures().add(new Picture(
                        newPicture.getOriginalFilename(),
                        newPicture.getContentType(),
                        pictureService.createPictureData(newPicture.getBytes()),
                        employee
                ));
            }
        }
        employeeRepository.save(employee);
    }


}
