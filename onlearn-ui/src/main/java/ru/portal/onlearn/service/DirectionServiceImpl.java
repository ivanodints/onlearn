package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.SphereOfActivitiesDTO;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.repo.specification.SphereOfActivitiesSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DirectionServiceImpl implements DirectionService {

    private final DirectionRepository directionRepository;
    private final FacultyRepository facultyRepository;

    public DirectionServiceImpl(DirectionRepository directionRepository,
                                FacultyRepository facultyRepository) {
        this.directionRepository = directionRepository;
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Optional<SphereOfActivitiesDTO> findById(Long id) {

        return directionRepository.findById(id).map(p -> DirectionService.mapToDTO(p));
    }

    @Override
    public List<SphereOfActivitiesDTO> showAllSphereOfActivities() {
        return directionRepository.findAll().stream().map(SphereOfActivitiesDTO::new).collect(Collectors.toList());
    }


    @Override
    public Page<SphereOfActivitiesDTO> findWithFilter(Long sphereOfActivitiesId,
                                                      Long facultyId,
                                                      Integer pageNumber,
                                                      Integer tableSize) {

        Specification <Direction> spec = Specification.where(null);

        if(sphereOfActivitiesId != null){
            spec = spec.and(SphereOfActivitiesSpecification.equalBySphereOfActivities(sphereOfActivitiesId));
        }

//        if(facultyId != null){
//            spec = spec.and(SphereOfActivitiesSpecification.equalByFaculty(facultyId));
//        }

//        Page<Long> ids = sphereOfActivitiesRepository.findAll(spec, PageRequest.of(pageNumber -1, tableSize))

        return null;
    }



    @Override
    public Page<SphereOfActivitiesDTO> findWithSphereOfActivitiesTitleFilter(String sphereOfActivitiesTitleFilter,
                                                                             String sort,
                                                                             Integer pageNumber,
                                                                             Integer tableSize) {

        Specification <Direction> spec = Specification.where(null);

        return null;
    }

    @Override
    public List<SphereOfActivitiesDTO> findByFacultyId(Long facultyId) {

        return null;
    }

    @Override
    public Page<SphereOfActivitiesDTO> findWithFacultyTitleFilter(String facultyTitleFilter,
                                                                  String sort,
                                                                  Integer pageNumber,
                                                                  Integer tableSize) {
        return null;
    }

    @Override
    public List<SphereOfActivitiesDTO> getFacultyTitles() {
        return null;
    }

    @Override
    public List<SphereOfActivitiesDTO> findBySphereOfActivitiesId(Long sphereOfActivitiesId) {
        return null;
    }


}
