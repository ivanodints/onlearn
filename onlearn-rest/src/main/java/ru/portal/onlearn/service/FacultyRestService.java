package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.FacultyRestDTO;
import ru.portal.onlearn.model.Faculty;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface FacultyRestService {

    Optional<FacultyRestDTO> findFacultyById(Long id);

    List<FacultyRestDTO> findAllFaculty();

    static FacultyRestDTO mapToDTO(Faculty faculty) {
        return new FacultyRestDTO(
                faculty.getId(),
                faculty.getTitle(),
                faculty.getPrice(),
                faculty.getDescription(),
                faculty.getDirection()
        );
    }
}
