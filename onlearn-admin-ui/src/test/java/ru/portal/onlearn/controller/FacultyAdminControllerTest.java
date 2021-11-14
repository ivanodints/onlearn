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
import ru.portal.onlearn.controller.DTO.DisciplineAdminDTO;
import ru.portal.onlearn.controller.DTO.FacultyAdminDTO;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.service.DirectionAdminService;
import ru.portal.onlearn.service.DisciplineAdminService;
import ru.portal.onlearn.service.FacultyAdminService;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest(classes = OnlearnAdminUiApplication.class)
public class FacultyAdminControllerTest {

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
    public void adminFacultyPageTest() throws Exception {

        mockMvc.perform(get("/admin/faculty"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("admin-faculty"))
                .andExpect(model().attributeExists("faculties"));

    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminDeleteFacultyTest() throws Exception {

        Direction direction = directionRepository.save(new Direction(1L,"Direction-1", "Direction test"));
        Faculty faculty1 = facultyRepository.save(new Faculty(1L,"Faculty-1",new BigDecimal(100), "Faculty test", direction));
        Faculty faculty2 = facultyRepository.save(new Faculty(2L,"Faculty-2",new BigDecimal(100), "Faculty-2 test", direction));


//        List<FacultyAdminDTO> facultyAdminDTOList = facultyRepository.findAll()
//                .stream()
//                .map(faculty -> new FacultyAdminDTO(faculty))
//                .collect(Collectors.toList());
//        System.out.println("Первый проход");
//        for(FacultyAdminDTO facultyAdminDTO: facultyAdminDTOList){
//            System.out.println("Факультет-"+facultyAdminDTO.getTitle());
//        }
//
//        facultyRepository.deleteById(faculty1.getId());
//        System.out.println("Второй проход");
//
//        facultyAdminDTOList = facultyRepository.findAll()
//                .stream()
//                .map(faculty -> new FacultyAdminDTO(faculty))
//                .collect(Collectors.toList());
//        for(FacultyAdminDTO facultyAdminDTO: facultyAdminDTOList){
//            System.out.println("Факультет-"+facultyAdminDTO.getTitle());
//        }


//        mockMvc.perform(delete("/admin/faculty/"+faculty1.getId()+"/delete")
//        )
//                .andExpect(status().isAccepted())
//        ;

    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminFacultyCreatePageTest() throws Exception {

        mockMvc.perform(get("/admin/faculty/create"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("faculty_form"))
                .andExpect(model().attributeExists("faculty"));
    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminEditFacultyTest() throws Exception {

        Direction direction = directionRepository.save(new Direction(1L,"Direction-1", "Direction test"));
        Faculty faculty = facultyRepository.save(new Faculty(1L,"Faculty-1",new BigDecimal(100), "Faculty test", direction));


        mockMvc.perform(get("/admin/faculty/"+faculty.getId()+"/edit"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("faculty_form"))
                .andExpect(model().attributeExists("faculty"))
                .andExpect(model().attributeExists("directions"))
                .andExpect(model().attribute("faculty", new BaseMatcher<Faculty>() {
                    @Override
                    public void describeTo(Description description) {

                    }

                    @Override
                    public boolean matches(Object actual) {
                        if (actual instanceof FacultyAdminDTO){
                            FacultyAdminDTO facultyAdminDTO = (FacultyAdminDTO) actual;
                            return facultyAdminDTO.getId().equals(faculty.getId());
                        }
                        return false;
                    }
                }));

    }

    @WithMockUser(value = "super-admin", password = "super-admin", roles = {"SUPER-ADMIN"})
    @Test
    public void adminPostFacultyTest() throws Exception {


    }
}
