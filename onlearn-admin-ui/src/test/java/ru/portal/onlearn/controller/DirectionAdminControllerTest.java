package ru.portal.onlearn.controller;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import ru.portal.onlearn.OnlearnAdminUiApplication;
import ru.portal.onlearn.controller.DTO.DepartmentAdminDTO;
import ru.portal.onlearn.controller.DTO.DirectionAdminDTO;
import ru.portal.onlearn.model.Department;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.service.DirectionAdminService;
import ru.portal.onlearn.service.FacultyAdminService;

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
public class DirectionAdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DirectionRepository  directionRepository;

    @Autowired
    private DirectionAdminService directionAdminService;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private FacultyAdminService facultyAdminService;

    @BeforeEach
    public void init(){
        directionRepository.deleteAllInBatch();
        facultyRepository.deleteAllInBatch();
    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminDirectionsPageTest() throws Exception {

        mockMvc.perform(get("/admin/direction"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("admin-direction"))
                .andExpect(model().attributeExists("directions"));

    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminDeleteDirectionTest() throws Exception {


//        Direction direction = new Direction(2L,"Direction-1", "Direction test");
//
//        directionRepository.save(direction);
//
//        mockMvc.perform(delete("/admin/direction/2/delete")
//        )
//                .andExpect(status().isAccepted())
//        ;

    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminDirectionCreatePageTest() throws Exception {

        mockMvc.perform(get("/admin/direction/create"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("direction_form"))
                .andExpect(model().attributeExists("direction"));

    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminEditDirectionTest() throws Exception {

        Direction direction = directionRepository.save(new Direction(1L,"Direction-1", "Direction test"));

        mockMvc.perform(get("/admin/direction/"+direction.getId()+"/edit"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("direction_form"))
                .andExpect(model().attributeExists("direction"))
                .andExpect(model().attribute("direction", new BaseMatcher<Direction>() {
                    @Override
                    public void describeTo(Description description) {

                    }

                    @Override
                    public boolean matches(Object actual) {
                        if (actual instanceof DirectionAdminDTO){
                            DirectionAdminDTO directionAdminDTO = (DirectionAdminDTO) actual;
                            return directionAdminDTO.getId().equals(direction.getId());
                        }
                        return false;
                    }
                }));

    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminPostDirectionTest() throws Exception {

    }
    
}
