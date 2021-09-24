package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.portal.onlearn.model.Direction;

import java.util.Optional;

public interface DirectionRepository extends JpaRepository<Direction, Long> {

    @Query("select d from Direction d where (d.title like :title or :title is null)")
    Direction findByTitle (@Param("title") String title);

}
