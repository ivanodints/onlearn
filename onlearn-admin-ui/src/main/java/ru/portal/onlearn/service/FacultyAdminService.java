package ru.portal.onlearn.service;

import ru.portal.onlearn.controller.DTO.FacultyAdminDTO;

import java.util.List;
import java.util.Optional;

@Service
public interface FacultyAdminService {
    Optional<FacultyAdminDTO> findById(Long id);

    Faculty findByTitle(String title);

    List<FacultyAdminDTO> findAll();

//    Page<FacultyAdminDTO> findByFilter(Long directionId, Integer pageNumber, Integer tableSize);

    public static FacultyAdminDTO mapToDTO(Faculty faculty) {
        return new FacultyAdminDTO(
                faculty.getId(),
                faculty.getTitle(),
                faculty.getPrice(),
                faculty.getDescription(),
                faculty.getDirection()
        );
    }
}
