package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.DirectionAdminDTO;
import ru.portal.onlearn.controller.DTO.StudentAdminDTO;
import ru.portal.onlearn.model.Direction;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface StudentAdminService {

    List<StudentAdminDTO> findAllStudent();

    Optional<StudentAdminDTO> findStudentById(Long id);

    StudentAdminDTO findStudentBySurname(String surname);

    void deleteStudentById(Long id);

    void saveStudent (StudentAdminDTO studentAdminDTO) throws IOException;
}
