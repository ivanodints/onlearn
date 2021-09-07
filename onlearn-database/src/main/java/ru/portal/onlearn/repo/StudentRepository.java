package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.portal.onlearn.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentsById (Long Id);
}
