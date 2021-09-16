package ru.portal.onlearn.service;

import ru.portal.onlearn.controller.DTO.FacultyAdminDTO;

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
    public Optional<FacultyAdminDTO> findById(Long id) {
        return facultyRepository.findById(id).map(faculty -> FacultyService.mapToDTO(faculty));
    }

    @Override
    public Faculty findByTitle(String title) {
        return facultyRepository.findByTitle(title);
    }

    @Override
    public List<FacultyAdminDTO> findAll() {
        return facultyRepository.findAll()
                .stream()
                .map(faculty -> new FacultyAdminDTO(faculty))
                .collect(Collectors.toList());
    }
}
