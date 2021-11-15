package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DisciplineRestDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.repo.FacultyRepository;

@Service
public class DisciplineRestServiceImpl implements DisciplineRestService {

    private final DisciplineRepository disciplineRepository;
    private final FacultyRepository facultyRepository;

    public DisciplineRestServiceImpl(DisciplineRepository disciplineRepository, FacultyRepository facultyRepository) {
        this.disciplineRepository = disciplineRepository;
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Optional<DisciplineRestDTO> findDisciplineById(Long id) {

        return disciplineRepository.findById(id).map(discipline -> DisciplineRestService.mapToDTO(discipline));
    }

    @Override
    public List<DisciplineRestDTO> findAllDiscipline() {

        return disciplineRepository.findAll()
                .stream()
                .map(discipline -> new DisciplineRestDTO(discipline))
                .collect(Collectors.toList());

    }

}
