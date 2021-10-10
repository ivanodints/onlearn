package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.EmployeeAdminDTO;
import ru.portal.onlearn.controller.DTO.PictureDTO;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.model.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public interface EmployeeAdminService {

    Optional<EmployeeAdminDTO> findEmployeeById(Long id);

    List<EmployeeAdminDTO> findAllEmployee();

    void deleteEmployeeById(Long id);

    Page<EmployeeAdminDTO> findByFilter(String surname, Integer page, Integer size);

    static EmployeeAdminDTO mapToAdminEmployeeDTO(Employee employee) {
        return new EmployeeAdminDTO(
                employee.getId(),
                employee.getName(),
                employee.getSurname(),
                employee.getMiddleName(),
                employee.getDateOfBirth(),
                employee.getSex(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getDepartment(),
                employee.getBio(),
                employee.getPictures().stream().map(picture -> new PictureDTO(picture)).collect(Collectors.toList()));
    }

    void saveEmployee (EmployeeAdminDTO employeeAdminDTO) throws IOException;

}
