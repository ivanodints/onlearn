package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.portal.onlearn.model.Faculty;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

//    Optional<Faculty> findFacultyByTitle(String title);
}
