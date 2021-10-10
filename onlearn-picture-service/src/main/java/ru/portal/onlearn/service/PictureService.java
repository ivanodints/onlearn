package ru.portal.onlearn.service;

import ru.portal.onlearn.controller.DTO.PictureDTO;
import ru.portal.onlearn.model.*;

import java.util.List;
import java.util.Optional;

public interface PictureService {

    Optional<String> getPictureContentTypeById(long id);

    Optional<byte[]> getPictureDataById(long id);

    PictureData createPictureData(byte[] picture);

    Optional<Discipline> getDisciplineByPictureId(long id);

    Optional<Faculty> getFacultyByPictureId(long id);

    Optional<Direction> getDirectionByPictureId(long id);

    Optional<Employee> getEmployeeByPictureId(long id);

    Optional<Student> getStudentByPictureId(long id);

    void removePicture(long id);

    Optional<PictureDTO> findPictureById (Long id);

    List<PictureDTO> findAllPictures();
}
