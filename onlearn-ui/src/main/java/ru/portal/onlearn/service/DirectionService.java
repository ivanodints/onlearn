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


    List<DirectionDTO> showAllDirection();

    List<DirectionDTO> getFacultyTitles();

    Optional<DirectionDTO> findById(Long id);


    Page<DirectionDTO> findWithFilter(Long sphereOfActivitiesId,
                                      Long sphereOfActivitiesTitle,
                                      Integer pageNumber,
                                      Integer tableSize);

    Page<DirectionDTO> findWithFacultyTitleFilter(String facultyTitleFilter,
                                                  String sort,
                                                  Integer pageNumber,
                                                  Integer tableSize);

    Page<DirectionDTO> findWithDirectionTitleFilter(String sphereOfActivitiesTitleFilter,
                                                    String sort,
                                                    Integer pageNumber,
                                                    Integer tableSize);

    List<DirectionDTO> findByFacultyId(Long facultyId);

    List<DirectionDTO> findDirectionId(Long sphereOfActivitiesId);


    public static DirectionDTO mapToDTO(Direction sp) {
        return new DirectionDTO(
                sp.getId(),
                sp.getTitle(),
                sp.getDescription(),
                sp.getFaculties().size() > 0 ? sp.getFaculties().get(0).getId() : null,
                sp.getFaculties().stream().map(Faculty::getId).collect(Collectors.toList()));
    }

//    public static SphereOfActivitiesDTO mapToDTO(SphereOfActivities sp) {
//        return new SphereOfActivitiesDTO(
//                sp.getId(),
//                sp.getTitle());
//    }
}
