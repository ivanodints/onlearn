package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DirectionDTO;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Direction;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface DirectionService {


    List<DirectionDTO> showAllDirections();

    List<DirectionDTO> getFacultyTitles();

    Optional<DirectionDTO> findById(Long id);


    Page<DirectionDTO> findWithFilter(Long directionId,
                                      Long directionTitle,
                                      Integer pageNumber,
                                      Integer tableSize);

    Page<DirectionDTO> findWithFacultyTitleFilter(String facultyTitleFilter,
                                                  String sort,
                                                  Integer pageNumber,
                                                  Integer tableSize);

    Page<DirectionDTO> findWithDirectionTitleFilter(String directionTitleFilter,
                                                             String sort,
                                                             Integer pageNumber,
                                                             Integer tableSize);

    List<DirectionDTO> findByFacultyId(Long facultyId);

    List<DirectionDTO> findByDirectionId(Long directionId);


    public static DirectionDTO mapToDTO(Direction dir) {
        return new DirectionDTO(
                dir.getId(),
                dir.getTitle(),
                dir.getFaculties().size() > 0 ? dir.getFaculties().get(0).getId() : null,
                dir.getFaculties().stream().map(Faculty :: getId).collect(Collectors.toList()));
    }

//    public static DirectionDTO mapToDTO(Direction dir) {
//        return new DirectionDTO(
//                dir.getId(),
//                dir.getTitle());
//    }
}
