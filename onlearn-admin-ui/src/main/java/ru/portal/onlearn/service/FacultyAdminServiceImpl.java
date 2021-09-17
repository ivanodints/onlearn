package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.FacultyAdminDTO;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.repo.FacultyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyAdminServiceImpl implements FacultyAdminService{

    private final FacultyRepository facultyRepository;


    public FacultyAdminServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Optional<FacultyAdminDTO> findFacultyById(Long id) {
        return facultyRepository.findById(id).map(faculty -> FacultyAdminService.mapToAdminFacultyDTO(faculty));
    }

    @Override
    public Faculty findFacultyByTitle(String title) {
        return facultyRepository.findByTitle(title);
    }

    @Override
    public List<FacultyAdminDTO> findAllFaculties() {
        return facultyRepository.findAll()
                .stream()
                .map(faculty -> new FacultyAdminDTO(faculty))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFacultyById(Long id) {
        facultyRepository.deleteById(id);
    }
}
