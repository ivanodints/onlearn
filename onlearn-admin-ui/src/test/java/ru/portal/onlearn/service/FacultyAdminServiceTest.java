package ru.portal.onlearn.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.portal.onlearn.controller.DTO.FacultyAdminDTO;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.repo.PictureRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FacultyAdminServiceTest {

    private FacultyAdminService facultyAdminService;
    private PictureService pictureService;
    private FacultyRepository facultyRepositoryMock;
    private PictureRepository pictureRepositoryMock;

    @BeforeEach
    public void init() {

        facultyRepositoryMock = mock(FacultyRepository.class);
        pictureRepositoryMock = mock(PictureRepository.class);
        pictureService = new PictureServiceImpl(pictureRepositoryMock);
        facultyAdminService = new FacultyAdminServiceImpl(facultyRepositoryMock, pictureService) {
        };
    }

    @Test
    public void findById(){

        Faculty faculty1 = new Faculty();
        faculty1.setId(1L);
        faculty1.setDescription("test-1 test-1");
        faculty1.setTitle("test-1");
        faculty1.setDirection(null);
        faculty1.setStudents(null);
        faculty1.setDisciplines(null);
        faculty1.setOrders(null);
        faculty1.setPrice(new BigDecimal(100));
        faculty1.setPictures(new ArrayList<>());

        when(facultyRepositoryMock.findById(1L)).thenReturn(Optional.of(faculty1));

        Optional<FacultyAdminDTO>facultyAdminDTO = facultyAdminService.findFacultyById(1L);

        assertTrue(facultyAdminDTO.isPresent());
        assertEquals(faculty1.getId(), facultyAdminDTO.get().getId());
        assertEquals(faculty1.getTitle(), facultyAdminDTO.get().getTitle());
        assertEquals(faculty1.getDescription(), facultyAdminDTO.get().getDescription());
        assertEquals(faculty1.getPrice(), facultyAdminDTO.get().getPrice());
        assertEquals(faculty1.getPictures(), facultyAdminDTO.get().getPictures());
        assertEquals(faculty1.getDirection(), facultyAdminDTO.get().getDirection());

    }

    @Test
    public void findAll(){

        Faculty faculty1 = new Faculty();
        faculty1.setId(1L);
        faculty1.setDescription("test-1 test-1");
        faculty1.setTitle("test-1");
        faculty1.setDirection(null);
        faculty1.setStudents(null);
        faculty1.setDisciplines(null);
        faculty1.setOrders(null);
        faculty1.setPrice(new BigDecimal(100));
        faculty1.setPictures(new ArrayList<>());

        Faculty faculty2 = new Faculty();
        faculty2.setId(2L);
        faculty2.setDescription("test-2 test-2");
        faculty2.setTitle("test-2");
        faculty2.setDirection(null);
        faculty2.setStudents(null);
        faculty2.setDisciplines(null);
        faculty2.setOrders(null);
        faculty2.setPrice(new BigDecimal(200));
        faculty2.setPictures(new ArrayList<>());

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(faculty1);
        facultyList.add(faculty2);

        when(facultyRepositoryMock.findAll()).thenReturn(facultyList);

        List<FacultyAdminDTO> facultyAdminDTOS = facultyAdminService.findAllFaculties();

        assertEquals(faculty1.getId(), facultyAdminDTOS.get(0).getId());
        assertEquals(faculty1.getTitle(), facultyAdminDTOS.get(0).getTitle());
        assertEquals(faculty2.getId(), facultyAdminDTOS.get(1).getId());
        assertEquals(faculty2.getTitle(), facultyAdminDTOS.get(1).getTitle());
        assertEquals(facultyRepositoryMock.findAll().size(), facultyAdminDTOS.size());

    }
}
