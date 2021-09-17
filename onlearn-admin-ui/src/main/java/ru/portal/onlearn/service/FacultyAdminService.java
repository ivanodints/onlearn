package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.FacultyAdminDTO;
import ru.portal.onlearn.model.Faculty;

import java.util.List;
import java.util.Optional;

@Service
public interface FacultyAdminService {

    Optional<FacultyAdminDTO> findFacultyById(Long id);

    Faculty findFacultyByTitle(String title);

    List<FacultyAdminDTO> findAllFaculties();

    void deleteFacultyById(Long id);

//    Page<FacultyAdminDTO> findByFilter(Long directionId, Integer pageNumber, Integer tableSize);

    public static FacultyAdminDTO mapToAdminFacultyDTO(Faculty faculty) {
        return new FacultyAdminDTO(
                faculty.getId(),
                faculty.getTitle(),
                faculty.getPrice(),
                faculty.getDescription(),
                faculty.getDirection()
        );
    }
}
