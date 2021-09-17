package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.FacultyDTO;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public interface FacultyService {

    Optional<FacultyDTO> findById(Long id);

    FacultyDTO findByTitle(String title);

    List<FacultyDTO> findAll();

//    Page<FacultyDTO> findByFilter(Long directionId, Integer pageNumber, Integer tableSize);

    public static FacultyDTO mapToDTO(Faculty faculty) {
        return new FacultyDTO(
                faculty.getId(),
                faculty.getTitle(),
                faculty.getPrice(),
                faculty.getDescription(),
                faculty.getDirection()
        );
    }

}
