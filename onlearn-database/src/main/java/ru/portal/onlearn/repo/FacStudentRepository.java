package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.portal.onlearn.model.FacStudent;

public interface FacStudentRepository extends JpaRepository<FacStudent, Long> {
}
