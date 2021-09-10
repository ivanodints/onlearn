package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.portal.onlearn.controller.DTO.SphereOfActivitiesDTO;
import ru.portal.onlearn.model.SphereOfActivities;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.repo.SphereOfActivitiesRepository;
import ru.portal.onlearn.repo.specification.SphereOfActivitiesSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SphereOfActivitiesServiceImpl implements SphereOfActivitiesService {

    private final SphereOfActivitiesRepository sphereOfActivitiesRepository;
    private final FacultyRepository facultyRepository;

    public SphereOfActivitiesServiceImpl(SphereOfActivitiesRepository sphereOfActivitiesRepository,
                                         FacultyRepository facultyRepository) {
        this.sphereOfActivitiesRepository = sphereOfActivitiesRepository;
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Optional<SphereOfActivitiesDTO> findById(Long id) {

        return sphereOfActivitiesRepository.findById(id).map(p -> SphereOfActivitiesService.mapToDTO(p));
    }

    @Override
    public List<SphereOfActivitiesDTO> showAllSphereOfActivities() {
        return sphereOfActivitiesRepository.findAll().stream().map(SphereOfActivitiesDTO::new).collect(Collectors.toList());
    }


    @Override
    public Page<SphereOfActivitiesDTO> findWithFilter(Long sphereOfActivitiesId,
                                                      Long facultyId,
                                                      Integer pageNumber,
                                                      Integer tableSize) {

        Specification <SphereOfActivities> spec = Specification.where(null);

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

        Specification <SphereOfActivities> spec = Specification.where(null);

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
