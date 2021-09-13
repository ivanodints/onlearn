package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.SphereOfActivitiesDTO;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Direction;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface DirectionService {


    List<SphereOfActivitiesDTO> showAllSphereOfActivities();

    List<SphereOfActivitiesDTO> getFacultyTitles();

    Optional<SphereOfActivitiesDTO> findById(Long id);


    Page<SphereOfActivitiesDTO> findWithFilter(Long sphereOfActivitiesId,
                                               Long sphereOfActivitiesTitle,
                                               Integer pageNumber,
                                               Integer tableSize);

    Page<SphereOfActivitiesDTO> findWithFacultyTitleFilter(String facultyTitleFilter,
                                                           String sort,
                                                           Integer pageNumber,
                                                           Integer tableSize);

    Page<SphereOfActivitiesDTO> findWithSphereOfActivitiesTitleFilter(String sphereOfActivitiesTitleFilter,
                                                                      String sort,
                                                                      Integer pageNumber,
                                                                      Integer tableSize);

    List<SphereOfActivitiesDTO> findByFacultyId(Long facultyId);

    List<SphereOfActivitiesDTO> findBySphereOfActivitiesId(Long sphereOfActivitiesId);


    public static SphereOfActivitiesDTO mapToDTO(Direction sp) {
        return new SphereOfActivitiesDTO(
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
