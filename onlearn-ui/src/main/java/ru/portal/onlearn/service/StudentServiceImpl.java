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
//        return null;
    }



    @Override
    @Transactional
    public void saveStudent(StudentDTO studentAdminDTO) throws IOException {

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
        student.setUser(studentAdminDTO.getUser());
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
