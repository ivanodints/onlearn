package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.portal.onlearn.controller.DTO.DisciplineAdminDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Picture;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.repo.specification.DisciplineSpecification;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplineAdminServiceImpl implements DisciplineAdminService{

    private final DisciplineRepository disciplineRepository;
    private final PictureService pictureService;

    public DisciplineAdminServiceImpl(DisciplineRepository disciplineRepository, PictureService pictureService) {
        this.disciplineRepository = disciplineRepository;
        this.pictureService = pictureService;
    }

    @Override
    public Optional<DisciplineAdminDTO> findDisciplineById(Long id){
        return disciplineRepository.findById(id).map(discipline -> DisciplineAdminService.mapToAdminDisciplineDTO(discipline));
    }

    @Override
    public List<DisciplineAdminDTO> findAllDiscipline(){
        return disciplineRepository.findAll()
                .stream()
                .map(discipline -> new DisciplineAdminDTO(discipline))
                .collect(Collectors.toList());
    }

    @Override
    public Page<DisciplineAdminDTO> findDisciplineTitle(String title, Integer page, Integer size){
        Specification<Discipline> spec = Specification.where(null);

        if (title != null){
            spec = spec.and(DisciplineSpecification.byTitle(title));
        }

        Page<Long> ids = disciplineRepository.findAll(PageRequest.of(page - 1, size))
                .map(Discipline::getId);

        List<DisciplineAdminDTO> allByIds = disciplineRepository.findAll().stream()
                .map(discipline -> DisciplineAdminService.mapToAdminDisciplineDTO(discipline))
                .collect(Collectors.toList());
        return new PageImpl<>(allByIds, PageRequest.of(page -1, size), ids.getTotalElements());
    }

    @Override
    public void deleteDisciplineById(Long id) {
        disciplineRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveDiscipline (DisciplineAdminDTO disciplineAdminDTO) throws IOException {

        Discipline discipline;
        if (disciplineAdminDTO.getId() != null) discipline = disciplineRepository.findById(disciplineAdminDTO.getId())
                .orElseThrow(NotFoundException::new);
        else discipline = new Discipline();
        discipline.setId(disciplineAdminDTO.getId());
        discipline.setTitle(disciplineAdminDTO.getTitle());
        discipline.setDiscTime(disciplineAdminDTO.getDiscTime());
        discipline.setDescription(disciplineAdminDTO.getDescription());
        if (disciplineAdminDTO.getNewPictures() != null){
            for (MultipartFile newPicture : disciplineAdminDTO.getNewPictures()){
                if (discipline.getPictures() == null){
                    discipline.setPictures(new ArrayList<>());
                }
                discipline.getPictures().add(new Picture(
                        newPicture.getOriginalFilename(),
                        newPicture.getContentType(),
                        pictureService.createPictureData(newPicture.getBytes()),
                        discipline
                ));
            }
        }
        disciplineRepository.save(discipline);
    }

    }
