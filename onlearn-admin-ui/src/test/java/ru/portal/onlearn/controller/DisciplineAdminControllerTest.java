package ru.portal.onlearn.controller;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import ru.portal.onlearn.OnlearnAdminUiApplication;
import ru.portal.onlearn.controller.DTO.DirectionAdminDTO;
import ru.portal.onlearn.controller.DTO.DisciplineAdminDTO;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.service.DirectionAdminService;
import ru.portal.onlearn.service.DisciplineAdminService;
import ru.portal.onlearn.service.FacultyAdminService;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest(classes = OnlearnAdminUiApplication.class)
public class DisciplineAdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DirectionRepository directionRepository;

    @Autowired
    private DirectionAdminService directionAdminService;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private DisciplineAdminService disciplineAdminService;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private FacultyAdminService facultyAdminService;

    @BeforeEach
    public void init(){
        directionRepository.deleteAllInBatch();
        facultyRepository.deleteAllInBatch();
        disciplineRepository.deleteAllInBatch();
    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminDisciplinesPageTest() throws Exception {

        mockMvc.perform(get("/admin/discipline"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("admin-discipline"))
                .andExpect(model().attributeExists("disciplines"))
                .andExpect(model().attributeExists("faculties"));

    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminDeleteDisciplineTest() throws Exception {

    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminDisciplineCreatePageTest() throws Exception {

        mockMvc.perform(get("/admin/discipline/create"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("discipline_form"))
                .andExpect(model().attributeExists("faculties"))
                .andExpect(model().attributeExists("discipline"));

    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminEditDisciplineTest() throws Exception {

        Discipline discipline = disciplineRepository.save(new Discipline(1L,"Discipline-1", LocalTime.now(), "Direction test"));

        mockMvc.perform(get("/admin/discipline/"+discipline.getId()+"/edit"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("discipline_form"))
                .andExpect(model().attributeExists("discipline"))
                .andExpect(model().attribute("discipline", new BaseMatcher<Discipline>() {
                    @Override
                    public void describeTo(Description description) {

                    }

                    @Override
                    public boolean matches(Object actual) {
                        if (actual instanceof DisciplineAdminDTO){
                            DisciplineAdminDTO disciplineAdminDTO = (DisciplineAdminDTO) actual;
                            return disciplineAdminDTO.getId().equals(discipline.getId());
                        }
                        return false;
                    }
                }));

    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminPostDisciplineTest() throws Exception {

    }
}

