package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Faculty;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    @Query("select d from Discipline d where (d.title like :title or :title is null)")
    Discipline findByTitle (@Param("title") String title);

}
