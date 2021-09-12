package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DirectionDTO;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.repo.specification.DirectionSpecification;

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
    public Optional<DirectionDTO> findById(Long id) {

        return directionRepository.findById(id).map(p -> DirectionService.mapToDTO(p));
    }

    @Override
    public List<DirectionDTO> showAllDirections() {
        return directionRepository.findAll().stream().map(DirectionDTO::new).collect(Collectors.toList());
    }


    @Override
    public Page<DirectionDTO> findWithFilter(Long directionId,
                                             Long facultyId,
                                             Integer pageNumber,
                                             Integer tableSize) {

        Specification <Direction> spec = Specification.where(null);

        if(directionId != null){
            spec = spec.and(DirectionSpecification.equalByDirection(directionId));
        }

//        if(facultyId != null){
//            spec = spec.and(DirectionSpecification.equalByFaculty(facultyId));
//        }

//        Page<Long> ids = directionRepository.findAll(spec, PageRequest.of(pageNumber -1, tableSize))

        return null;
    }



    @Override
    public Page<DirectionDTO> findWithDirectionTitleFilter(String directionTitleFilter,
                                                                    String sort,
                                                                    Integer pageNumber,
                                                                    Integer tableSize) {

        Specification <Direction> spec = Specification.where(null);

        return null;
    }

    @Override
    public List<DirectionDTO> findByFacultyId(Long facultyId) {

        return null;
    }

    @Override
    public Page<DirectionDTO> findWithFacultyTitleFilter(String facultyTitleFilter,
                                                         String sort,
                                                         Integer pageNumber,
                                                         Integer tableSize) {
        return null;
    }

    @Override
    public List<DirectionDTO> getFacultyTitles() {
        return null;
    }

    @Override
    public List<DirectionDTO> findByDirectionId(Long directionId) {
        return null;
    }


}
