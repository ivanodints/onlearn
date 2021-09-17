package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.StudentAdminDTO;
import ru.portal.onlearn.controller.DTO.StudentDTO;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.repo.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentAdminServiceImpl implements StudentAdminService{

    private final StudentRepository studentRepository;

    public StudentAdminServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
}
