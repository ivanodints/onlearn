package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.EmployeeAdminDTO;
import ru.portal.onlearn.model.Employee;

import java.util.List;
import java.util.Optional;


@Service
public interface EmployeeAdminService {

    Optional<EmployeeAdminDTO> findById(Long id);

    List<EmployeeAdminDTO> findAll();

    Page<EmployeeAdminDTO> findByFilter(String surname, Integer page, Integer size);

    public static EmployeeAdminDTO mapToDTO(Employee employee) {
        return new EmployeeAdminDTO(
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
