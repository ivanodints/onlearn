package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.portal.onlearn.controller.DTO.StudentDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Picture;
import ru.portal.onlearn.model.Student;
import ru.portal.onlearn.model.User;
import ru.portal.onlearn.repo.StudentRepository;
import ru.portal.onlearn.repo.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final PictureService pictureService;
    private final UserRepository userRepository;

    public StudentServiceImpl(StudentRepository studentRepository, PictureService pictureService, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.pictureService = pictureService;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<StudentDTO> findStudentById(Long id) {
        return studentRepository.findById(id).map(student -> StudentService.mapToStudentDTO(student));
    }

    @Override
    public Optional<StudentDTO> findByUserLogin(String login) {
        Student student = studentRepository.findByUserLogin(login);
        StudentDTO studentDTO = new StudentDTO(student);
        return Optional.of(studentDTO);
    }



    @Override
    @Transactional
    public void saveStudent(StudentDTO studentDTO) throws IOException {

        Student student;
        if (studentDTO.getId() != null) student = studentRepository.findById(studentDTO.getId())
                .orElseThrow(NotFoundException::new);
        else student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        student.setMiddleName(studentDTO.getMiddleName());
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        student.setSex(studentDTO.getSex());
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setUser(studentDTO.getUser());
        if (studentDTO.getNewUIPictures() != null){
            for (MultipartFile newUIPicture : studentDTO.getNewUIPictures()){
                if (student.getPictures() == null){
                    student.setPictures(new ArrayList<>());
                }
                student.getPictures().add(new Picture(
                        newUIPicture.getOriginalFilename(),
                        newUIPicture.getContentType(),
                        pictureService.createPictureData(newUIPicture.getBytes()),
                        student
                ));
            }
        }
        studentRepository.save(student);
    }

}
