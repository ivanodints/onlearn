package ru.portal.onlearn.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.portal.onlearn.controller.DTO.DepartmentAdminDTO;
import ru.portal.onlearn.model.Department;
import ru.portal.onlearn.repo.DepartmentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DepartmentAdmineServiceTest {

    private DepartmentAdminService departmentAdminService;
    private PictureService pictureService;
    private DepartmentRepository departmentRepositoryMock;


    @BeforeEach
    public void init(){

        departmentRepositoryMock = mock(DepartmentRepository.class);
        departmentAdminService = new DepartmentAdminServiceImpl(departmentRepositoryMock) {
        };
    }
    @Test
    public void findById(){

        Department department1 = new Department();
        department1.setId(1L);
        department1.setTitle("Departament-1");
        department1.setEmployees(null);

        when(departmentRepositoryMock.findById(eq(1L))).
                thenReturn(Optional.of(department1));

        Optional<DepartmentAdminDTO> departmentAdminDTO = departmentAdminService.findDepartmentById(1L);

        assertTrue(departmentAdminDTO.isPresent());
        assertEquals(department1.getId(), departmentAdminDTO.get().getId());
        assertEquals(department1.getTitle(), departmentAdminDTO.get().getTitle());
        assertEquals(department1.getEmployees(), departmentAdminDTO.get().getEmployees());

    }


    @Test
    public void findAll(){

        List<Department> departmentList = new ArrayList<>();

        Department department1 = new Department();
        department1.setId(1L);
        department1.setTitle("Departament-1");
        department1.setEmployees(null);

        Department department2 = new Department();
        department2.setId(2L);
        department2.setTitle("Departament-2");
        department2.setEmployees(null);

        departmentList.add(department1);
        departmentList.add(department2);

        when(departmentRepositoryMock.findAll())
        .thenReturn(departmentList);

        List<DepartmentAdminDTO> departmentAdminDTOList = departmentAdminService.findAllDepartment();

        assertEquals(department1.getId(), departmentAdminDTOList.get(0).getId());
        assertEquals(department1.getTitle(), departmentAdminDTOList.get(0).getTitle());
        assertEquals(department2.getId(), departmentAdminDTOList.get(1).getId());
        assertEquals(department2.getTitle(), departmentAdminDTOList.get(1).getTitle());
        assertEquals(departmentRepositoryMock.findAll().size(), departmentAdminDTOList.size());

    }
}
