package ru.portal.onlearn.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.portal.onlearn.controller.DTO.DisciplineAdminDTO;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.repo.PictureRepository;


import java.time.LocalTime;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DisciplineAdminServiceTest {

    private DisciplineAdminService disciplineAdminService;
    private PictureService pictureService;
    private DisciplineRepository disciplineRepositoryMock;
    private PictureRepository pictureRepositoryMock;

    @BeforeEach
    public void init(){

        disciplineRepositoryMock = mock(DisciplineRepository.class);
        pictureRepositoryMock = mock(PictureRepository.class);
        pictureService = new PictureServiceImpl(pictureRepositoryMock);
        disciplineAdminService = new DisciplineAdminServiceImpl(disciplineRepositoryMock, pictureService) {
        };
    }

    @Test
    public void findById(){

        Discipline discipline1 = new Discipline();
        discipline1.setId(1L);
        discipline1.setTitle("DisciplineTest");
        discipline1.setDescription("test test test");
        discipline1.setDiscTime(LocalTime.now());
        discipline1.setEmployees(null);
        discipline1.setFaculty(null);
        discipline1.setPictures(new ArrayList<>());

        when(disciplineRepositoryMock.findById(eq(1L))).
                thenReturn(Optional.of(discipline1));


        Optional<DisciplineAdminDTO> disciplineAdminDTO = disciplineAdminService.findDisciplineById(1L);

        assertTrue(disciplineAdminDTO.isPresent());
        assertEquals(discipline1.getId(), disciplineAdminDTO.get().getId());
        assertEquals(discipline1.getTitle(), disciplineAdminDTO.get().getTitle());
        assertEquals(discipline1.getDescription(), disciplineAdminDTO.get().getDescription());
        assertEquals(discipline1.getDiscTime(), disciplineAdminDTO.get().getDiscTime());
        assertEquals(discipline1.getPictures(), disciplineAdminDTO.get().getPictures());
        assertEquals(discipline1.getFaculty(), disciplineAdminDTO.get().getFaculty());
        assertEquals(discipline1.getEmployees(), disciplineAdminDTO.get().getEmployees());

    }

    @Test
    public void findAll(){

        List<Discipline> disciplineAdminList = new ArrayList<>();

        Discipline discipline1 = new Discipline();
        discipline1.setId(1L);
        discipline1.setTitle("DisciplineTest-1");
        discipline1.setDescription("test-1 test-1 test-1");
        discipline1.setDiscTime(LocalTime.now());
        discipline1.setEmployees(null);
        discipline1.setFaculty(null);
        discipline1.setPictures(new ArrayList<>());

        Discipline discipline2 = new Discipline();
        discipline2.setId(2L);
        discipline2.setTitle("DisciplineTest-2");
        discipline2.setDescription("test-2 test-2 test-2");
        discipline2.setDiscTime(LocalTime.now());
        discipline2.setEmployees(null);
        discipline2.setFaculty(null);
        discipline2.setPictures(new ArrayList<>());

        disciplineAdminList.add(discipline1);
        disciplineAdminList.add(discipline2);

        when(disciplineRepositoryMock.findAll()).
                thenReturn(disciplineAdminList);

        List<DisciplineAdminDTO> disciplineAdminDTOList = disciplineAdminService.findAllDiscipline();
        assertEquals(discipline1.getId(), disciplineAdminDTOList.get(0).getId());
        assertEquals(discipline1.getTitle(), disciplineAdminDTOList.get(0).getTitle());
        assertEquals(discipline2.getId(), disciplineAdminDTOList.get(1).getId());
        assertEquals(discipline2.getTitle(), disciplineAdminDTOList.get(1).getTitle());
        assertEquals(disciplineRepositoryMock.findAll().size(), disciplineAdminDTOList.size());

    }
}
