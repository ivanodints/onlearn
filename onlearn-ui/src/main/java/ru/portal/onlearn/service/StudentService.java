package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.PictureDTO;
import ru.portal.onlearn.controller.DTO.StudentDTO;
import ru.portal.onlearn.model.Student;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface StudentService {

    Optional<StudentDTO> findStudentById(Long id);

    Optional<StudentDTO> findByUserLogin(String login);

    void saveStudent (StudentDTO studentDTO) throws IOException;

    static StudentDTO mapToStudentDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getMiddleName(),
                student.getDateOfBirth(),
                student.getSex(),
                student.getEmail(),
                student.getPhoneNumber(),
                student.getPictures().stream().map(picture -> new PictureDTO(picture)).collect(Collectors.toList()));
    }


}
