package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.EmployeeAdminDTO;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.repo.EmployeeRepository;
import ru.portal.onlearn.repo.specification.EmployeeSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeAdminServiceImpl implements EmployeeAdminService {

    private final EmployeeRepository employeeRepository;

    public EmployeeAdminServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
}
