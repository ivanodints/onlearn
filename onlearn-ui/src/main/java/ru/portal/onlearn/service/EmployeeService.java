package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import ru.portal.onlearn.controller.DTO.EmployeeDTO;
import ru.portal.onlearn.model.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {


    Optional<EmployeeDTO> findById(Long id);

    List<EmployeeDTO> findAll();

    Page<EmployeeDTO> findByFilter(String surname, Integer page, Integer size);

    public static EmployeeDTO mapToDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getSurname(),
                employee.getMiddleName(),
                employee.getDateOfBirth(),
                employee.getSex(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getDepartment());
    }
}
