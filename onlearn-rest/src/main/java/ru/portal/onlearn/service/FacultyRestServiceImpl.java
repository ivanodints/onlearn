package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.FacultyRestDTO;
import ru.portal.onlearn.repo.FacultyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyRestServiceImpl implements FacultyRestService {

    private final FacultyRepository facultyRepository;

    public FacultyRestServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Optional<FacultyRestDTO> findFacultyById(Long id) {
        return facultyRepository.findById(id).map(faculty -> FacultyRestService.mapToDTO(faculty));
    }


    @Override
    public List<FacultyRestDTO> findAllFaculty() {

        return facultyRepository.findAll()
                .stream()
                .map(faculty -> new FacultyRestDTO(faculty))
                .collect(Collectors.toList());
    }
}
