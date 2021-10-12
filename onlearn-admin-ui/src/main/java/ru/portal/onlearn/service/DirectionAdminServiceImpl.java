package ru.portal.onlearn.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.portal.onlearn.controller.DTO.DirectionAdminDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Picture;
import ru.portal.onlearn.repo.DirectionRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DirectionAdminServiceImpl implements DirectionAdminService {

    private final DirectionRepository directionRepository;
    private final PictureService pictureService;

    public DirectionAdminServiceImpl(DirectionRepository directionRepository, PictureService pictureService) {
        this.directionRepository = directionRepository;
        this.pictureService = pictureService;
    }

    @Override
    public List<DirectionAdminDTO> findAllDirection() {

        return directionRepository.findAll()
                .stream()
                .map(direction -> new DirectionAdminDTO(direction))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DirectionAdminDTO> findDirectionById(Long id) {
        return directionRepository.findById(id)
                .map(direction -> DirectionAdminService.mapToAdminDirectionDTO(direction));
    }

    @Override
    public Direction findByTitle(String title) {

        return directionRepository.findByTitle(title);
    }

    @Override
    public void deleteDirectionById(Long id) {
        directionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveDirection(DirectionAdminDTO directionAdminDTO) throws IOException {

        Direction direction;
        if (directionAdminDTO.getId() != null) direction = directionRepository.findById(directionAdminDTO.getId())
                .orElseThrow(NotFoundException::new);
        else direction = new Direction();
        direction.setId(directionAdminDTO.getId());
        direction.setTitle(directionAdminDTO.getTitle());
        direction.setDescription(directionAdminDTO.getDescription());
        if (directionAdminDTO.getNewPictures() != null){
            for (MultipartFile newPicture : directionAdminDTO.getNewPictures()){
                if (direction.getPictures() == null){
                    direction.setPictures(new ArrayList<>());
                }
                direction.getPictures().add(new Picture(
                        newPicture.getOriginalFilename(),
                        newPicture.getContentType(),
                        pictureService.createPictureData(newPicture.getBytes()),
                        direction
                ));
            }
        }
        directionRepository.save(direction);
    }
}
