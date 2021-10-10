package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DirectionAdminDTO;
import ru.portal.onlearn.controller.DTO.EmployeeAdminDTO;
import ru.portal.onlearn.controller.DTO.PictureDTO;
import ru.portal.onlearn.controller.DTO.StudentAdminDTO;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.model.Student;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface StudentAdminService {

    List<StudentAdminDTO> findAllStudent();

    Optional<StudentAdminDTO> findStudentById(Long id);

    StudentAdminDTO findStudentBySurname(String surname);

    void deleteStudentById(Long id);

    void saveStudent (StudentAdminDTO studentAdminDTO) throws IOException;

    static StudentAdminDTO mapToAdminStudentDTO(Student student) {
        return new StudentAdminDTO(
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
