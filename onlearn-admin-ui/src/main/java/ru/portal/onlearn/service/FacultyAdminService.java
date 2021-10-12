package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DirectionAdminDTO;
import ru.portal.onlearn.controller.DTO.FacultyAdminDTO;
import ru.portal.onlearn.controller.DTO.PictureDTO;
import ru.portal.onlearn.model.Faculty;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface FacultyAdminService {

    Optional<FacultyAdminDTO> findFacultyById(Long id);

    Faculty findFacultyByTitle(String title);

    List<FacultyAdminDTO> findAllFaculties();

    void deleteFacultyById(Long id);


    static FacultyAdminDTO mapToAdminFacultyDTO(Faculty faculty) {
        return new FacultyAdminDTO(
                faculty.getId(),
                faculty.getTitle(),
                faculty.getPrice(),
                faculty.getDescription(),
                faculty.getPictures().stream().map(picture -> new PictureDTO(picture)).collect(Collectors.toList())
        );
    }

    void saveFaculty (FacultyAdminDTO facultyAdminDTO) throws IOException;
}
