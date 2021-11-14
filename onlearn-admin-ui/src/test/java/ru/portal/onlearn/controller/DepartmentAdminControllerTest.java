package ru.portal.onlearn.controller;


import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.portal.onlearn.OnlearnAdminUiApplication;
import ru.portal.onlearn.controller.DTO.DepartmentAdminDTO;
import ru.portal.onlearn.model.Department;
import ru.portal.onlearn.repo.DepartmentRepository;
import ru.portal.onlearn.service.DepartmentAdminService;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest(classes = OnlearnAdminUiApplication.class)
public class DepartmentAdminControllerTest {

    @Autowired
    private MockMvc  mockMvc;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentAdminService departmentAdminService;

    @BeforeEach
    public void init(){
        departmentRepository.deleteAllInBatch();
    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminDepartmentsPageTest() throws Exception {


        Department department1 = new Department();
        department1.setId(1L);
        department1.setTitle("departament-1");


        Department department2 = new Department();
        department2.setId(2L);
        department2.setTitle("departament-2");

        departmentRepository.save(department1);
        departmentRepository.save(department2);

        mockMvc.perform(get("/admin/department"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("admin-department"))
                .andExpect(model().attributeExists("departments"));

    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminDepartmentCreatePageTest() throws Exception {

        mockMvc.perform(get("/admin/department/create"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("department_form"))
                .andExpect(model().attributeExists("department"));
    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminEditDepartmentTest() throws Exception {

        Department department1 = departmentRepository.save(new Department(1L, "departament-1", null));

        mockMvc.perform(get("/admin/department/"+department1.getId()+"/edit"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("department_form"))
                .andExpect(model().attributeExists("department"))
                .andExpect(model().attribute("department", new BaseMatcher<Department>() {
                    @Override
                    public void describeTo(Description description) {

                    }

                    @Override
                    public boolean matches(Object actual) {
                        if (actual instanceof DepartmentAdminDTO){
                            DepartmentAdminDTO departmentAdminDTO = (DepartmentAdminDTO) actual;
                            return departmentAdminDTO.getId().equals(department1.getId());
                        }
                        return false;
                    }
                }));
    }


    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminPostDepartmentTest() throws Exception {

        mockMvc.perform(post("/admin/departmentPost")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "1L")
                .param("title", "testDept")
                .with(csrf())
        )
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("department_form"));
    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminDeleteDepartmentTest() throws Exception {


        Department department3 = new Department();
        department3.setTitle("departament-3");
        department3.setId(2L);
        department3.setEmployees(null);

        departmentRepository.save(department3);




//        mockMvc.perform(delete("/admin/department/"+department3.getId()+"/delete")
        mockMvc.perform(delete("/admin/department/2/delete")
                )
                .andExpect(status().isAccepted())
                ;
    }
}
