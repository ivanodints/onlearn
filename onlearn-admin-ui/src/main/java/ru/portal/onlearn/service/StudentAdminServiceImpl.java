package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.portal.onlearn.controller.DTO.StudentAdminDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Picture;
import ru.portal.onlearn.model.Student;
import ru.portal.onlearn.repo.StudentRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentAdminServiceImpl implements StudentAdminService{

    private final StudentRepository studentRepository;
    private final PictureService pictureService;

    public StudentAdminServiceImpl(StudentRepository studentRepository, PictureService pictureService) {
        this.studentRepository = studentRepository;
        this.pictureService = pictureService;
    }

    @Override
    public List<StudentAdminDTO> findAllStudent() {
        return studentRepository.findAll()
                .stream()
                .map(student -> new StudentAdminDTO(student))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentAdminDTO> findStudentById(Long id) {
        return studentRepository.findById(id).map(student -> new StudentAdminDTO(student));
    }

    @Override
    public StudentAdminDTO findStudentBySurname(String surname) {

        StudentAdminDTO studentAdminDTO = new StudentAdminDTO(studentRepository.findBySurname(surname));

        return studentAdminDTO;
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveStudent(StudentAdminDTO studentAdminDTO) throws IOException {

        Student student;
        if (studentAdminDTO.getId() != null) student = studentRepository.findById(studentAdminDTO.getId())
                .orElseThrow(NotFoundException::new);
        else student = new Student();
        student.setId(studentAdminDTO.getId());
        student.setName(studentAdminDTO.getName());
        student.setSurname(studentAdminDTO.getSurname());
        student.setMiddleName(studentAdminDTO.getMiddleName());
        student.setDateOfBirth(studentAdminDTO.getDateOfBirth());
        student.setSex(studentAdminDTO.getSex());
        student.setEmail(studentAdminDTO.getEmail());
        student.setPhoneNumber(studentAdminDTO.getPhoneNumber());
        if (studentAdminDTO.getNewPictures() != null){
            for (MultipartFile newPicture : studentAdminDTO.getNewPictures()){
                if (student.getPictures() == null){
                    student.setPictures(new ArrayList<>());
                }
                student.getPictures().add(new Picture(
                        newPicture.getOriginalFilename(),
                        newPicture.getContentType(),
                        pictureService.createPictureData(newPicture.getBytes()),
                        student
                ));
            }
        }
        studentRepository.save(student);
    }
}
