package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import ru.portal.onlearn.controller.DTO.EmployeeDTO;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.repo.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface EmployeeService {


    Optional<EmployeeDTO> findById(Long id);

    Page<Employee> findAll();

    Page<EmployeeDTO> findByFilter(String surname, Integer page, Integer size);

    public static EmployeeDTO mapToDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(), employee.getName(),
                employee.getSurname(), employee.getMiddleName(),
                employee.getDateOfBirth(), employee.getSex(),
                employee.getEmail(), employee.getPhoneNumber(),
                employee.getDepartment());
    }
}
