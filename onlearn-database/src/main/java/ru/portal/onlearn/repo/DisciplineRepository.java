package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.portal.onlearn.model.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

}
