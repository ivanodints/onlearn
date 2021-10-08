package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.portal.onlearn.controller.DTO.PictureDTO;
import ru.portal.onlearn.model.*;
import ru.portal.onlearn.repo.PictureRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService{

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Optional<String> getPictureContentTypeById(long id) {
        return pictureRepository.findById(id)
                .filter(pic -> pic.getPictureData().getData() != null)
                .map(picture -> picture.getContentType());
    }

    @Override
    public Optional<byte[]> getPictureDataById(long id) {
        return pictureRepository.findById(id)
                .filter(pic -> pic.getPictureData().getData() != null)
                .map(pic -> pic.getPictureData().getData());
    }

    @Override
    public PictureData createPictureData(byte[] picture) {
        return new PictureData(picture);
    }

    @Override
    public Optional<Discipline> getDisciplineByPictureId(long id) {
        return pictureRepository.findById(id)
                .map(picture -> picture.getDiscipline());
    }

    @Override
    public Optional<Faculty> getFacultyByPictureId(long id) {
        return pictureRepository.findById(id)
                .map(picture -> picture.getFaculty());
    }

    @Override
    public Optional<Direction> getDirectionByPictureId(long id) {
        return pictureRepository.findById(id)
                .map(picture -> picture.getDirection());
    }

    @Override
    public Optional<Employee> getEmployeeByPictureId(long id) {
        return pictureRepository.findById(id)
                .map(picture -> picture.getEmployee());
    }

    @Override
    public Optional<Student> getStudentByPictureId(long id) {
        return pictureRepository.findById(id)
                .map(picture -> picture.getStudent());
    }

    @Override
    @Transactional
    public void removePicture(long id) {
        pictureRepository.deleteById(id);
    }

    @Override
    public Optional<PictureDTO> findPictureById(Long id) {
        return pictureRepository.findById(id).map(picture -> new PictureDTO(picture));
    }

    @Override
    public List<PictureDTO> showAllPictures() {
        return pictureRepository.findAll().stream().map(picture -> new PictureDTO(picture)).
                collect(Collectors.toList());
    }
}
