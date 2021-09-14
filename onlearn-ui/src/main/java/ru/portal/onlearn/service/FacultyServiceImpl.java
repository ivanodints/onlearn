package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.FacultyDTO;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.repo.specification.FacultySpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;


    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Optional<FacultyDTO> findById(Long id) {
        return facultyRepository.findById(id).map(faculty -> FacultyService.mapToDTO(faculty));
    }

    @Override
    public Faculty findByTitle(String title) {
        return facultyRepository.findByTitle(title);
    }

    @Override
    public List<FacultyDTO> findAll() {
        return facultyRepository.findAll()
                .stream()
                .map(faculty -> new FacultyDTO(faculty))
                .collect(Collectors.toList());
    }
}