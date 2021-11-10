package ru.portal.onlearn.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.portal.onlearn.controller.DTO.DirectionAdminDTO;
import ru.portal.onlearn.controller.DTO.DisciplineAdminDTO;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.repo.PictureRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DirectionAdmineServiceTest {

    private DirectionAdminService directionAdminService;
    private PictureService pictureService;
    private DirectionRepository directionRepositoryMock;
    private PictureRepository pictureRepositoryMock;

    @BeforeEach
    public void init(){

        directionRepositoryMock = mock(DirectionRepository.class);
        pictureRepositoryMock = mock(PictureRepository.class);
        pictureService = new PictureServiceImpl(pictureRepositoryMock);
        directionAdminService = new DirectionAdminServiceImpl(directionRepositoryMock, pictureService) {
        };

    }

    @Test
    public void findById(){

        Direction direction1 = new Direction();
        direction1.setId(1L);
        direction1.setTitle("Test-1");
        direction1.setDescription("test-1 test-1");
        direction1.setFaculties(null);
        direction1.setPictures(new ArrayList<>());

        when(directionRepositoryMock.findById(1L)).thenReturn(Optional.of(direction1));

        Optional<DirectionAdminDTO> directionAdminDTO = directionAdminService.findDirectionById(1L);

        assertTrue(directionAdminDTO.isPresent());
        assertEquals(direction1.getId(), directionAdminDTO.get().getId());
        assertEquals(direction1.getTitle(), directionAdminDTO.get().getTitle());
        assertEquals(direction1.getDescription(), directionAdminDTO.get().getDescription());
        assertEquals(direction1.getPictures(), directionAdminDTO.get().getPictures());

    }

    @Test
    public void findAll(){

        Direction direction1 = new Direction();
        direction1.setId(1L);
        direction1.setTitle("Test-1");
        direction1.setDescription("test-1 test-1");
        direction1.setFaculties(null);
        direction1.setPictures(new ArrayList<>());

        Direction direction2 = new Direction();
        direction2.setId(2L);
        direction2.setTitle("Test-2");
        direction2.setDescription("test-2 test-2");
        direction2.setFaculties(null);
        direction2.setPictures(new ArrayList<>());

        List<Direction>directionList =new ArrayList<>();
        directionList.add(direction1);
        directionList.add(direction2);

        when(directionRepositoryMock.findAll()).thenReturn(directionList);

        List<DirectionAdminDTO> directionAdminDTOS = directionAdminService.findAllDirection();
        assertEquals(direction1.getId(), directionAdminDTOS.get(0).getId());
        assertEquals(direction1.getTitle(), directionAdminDTOS.get(0).getTitle());
        assertEquals(direction2.getId(), directionAdminDTOS.get(1).getId());
        assertEquals(direction2.getTitle(), directionAdminDTOS.get(1).getTitle());
        assertEquals(directionRepositoryMock.findAll().size(), directionAdminDTOS.size());

    }
}
