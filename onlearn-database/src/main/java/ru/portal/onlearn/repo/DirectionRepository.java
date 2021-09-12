package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.portal.onlearn.model.Direction;

public interface DirectionRepository extends JpaRepository<Direction, Long> {

}
