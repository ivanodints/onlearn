package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Faculty;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    @Query("select f from Faculty f where (f.title like :title or :title is null)")
    Faculty findByTitle (@Param("title") String title);

}
