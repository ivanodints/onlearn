package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.FacultyDTO;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Student;

import java.util.*;
import java.util.stream.Collectors;


@Service
public interface FacultyService {

    Optional<FacultyDTO> findFacultyById(Long id);

    FacultyDTO findByTitle(String title);

    List<FacultyDTO> findAllFaculty();

    List<FacultyDTO> findByDirectionId(Long id);

//    Page<FacultyDTO> findByFilter(Long directionId, Integer pageNumber, Integer tableSize);

    static FacultyDTO mapToDTO(Faculty faculty) {
        return new FacultyDTO(
                faculty.getId(),
                faculty.getTitle(),
                faculty.getPrice(),
                faculty.getDescription(),
                faculty.getDirection(),
                faculty.getPictures().size() > 0 ? faculty.getPictures().get(0).getId() : null,
                faculty.getPictures().stream().map(picture -> picture.getId()).collect(Collectors.toList())
        );
    }

}
