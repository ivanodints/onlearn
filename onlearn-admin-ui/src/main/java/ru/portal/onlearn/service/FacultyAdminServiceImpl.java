package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.portal.onlearn.controller.DTO.FacultyAdminDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Picture;
import ru.portal.onlearn.repo.FacultyRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyAdminServiceImpl implements FacultyAdminService{

    private final FacultyRepository facultyRepository;
    private final PictureService pictureService;


    public FacultyAdminServiceImpl(FacultyRepository facultyRepository, PictureService pictureService) {
        this.facultyRepository = facultyRepository;
        this.pictureService = pictureService;
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

    @Override
    @Transactional
    public void saveFaculty (FacultyAdminDTO facultyAdminDTO) throws IOException {

        Faculty faculty;
        if (facultyAdminDTO.getId() != null) faculty = facultyRepository.findById(facultyAdminDTO.getId())
                .orElseThrow(NotFoundException::new);
        else faculty = new Faculty();
        faculty.setId(facultyAdminDTO.getId());
        faculty.setTitle(facultyAdminDTO.getTitle());
        faculty.setPrice(facultyAdminDTO.getPrice());
        faculty.setDescription(facultyAdminDTO.getDescription());
        faculty.setDirection(facultyAdminDTO.getDirection());
        if (facultyAdminDTO.getNewPictures() != null){
            for (MultipartFile newPicture : facultyAdminDTO.getNewPictures()){
                if (faculty.getPictures() == null){
                    faculty.setPictures(new ArrayList<>());
                }
                faculty.getPictures().add(new Picture(
                        newPicture.getOriginalFilename(),
                        newPicture.getContentType(),
                        pictureService.createPictureData(newPicture.getBytes()),
                        faculty

                ));
            }
        }
        facultyRepository.save(faculty);

    }
}
