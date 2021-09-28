package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DepartmentAdminDTO;
import ru.portal.onlearn.model.Department;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentAdminService {

    List<DepartmentAdminDTO> findAllDepartment();

    Optional<DepartmentAdminDTO> findDepartmentById(Long id);

    Department findByTitle (String title);

    public static DepartmentAdminDTO mapToAdminDepartmentDTO(Department department) {
        return new DepartmentAdminDTO(
                department.getId(),
                department.getTitle());
    }

    void deleteDepartmentById(Long id);

}
