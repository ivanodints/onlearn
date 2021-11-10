package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DepartmentAdminDTO;
import ru.portal.onlearn.model.Department;
import ru.portal.onlearn.repo.DepartmentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentAdminServiceImpl implements DepartmentAdminService {

    private final DepartmentRepository departmentRepository;

    public DepartmentAdminServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentAdminDTO> findAllDepartment() {
        return departmentRepository.findAll()
                .stream()
                .map(department -> new DepartmentAdminDTO(department))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DepartmentAdminDTO> findDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .map(department ->DepartmentAdminService.mapToAdminDepartmentDTO(department));
    }

    @Override
    public Department findByTitle(String title) {

        return departmentRepository.findByTitle(title);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }


}
