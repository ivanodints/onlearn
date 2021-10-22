package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.portal.onlearn.model.Discipline;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    @Query("select d from Discipline d where (d.title like :title or :title is null)")
    Discipline findByTitle (@Param("title") String title);

    @Query(value = "SELECT * FROM Discipline ds INNER JOIN fac_disc ON ds.id = fac_disc.disc_id " +
            "INNER JOIN Faculty f ON fac_disc.fac_id = f.id WHERE f.id = ?1", nativeQuery = true)
    List<Discipline> findDisciplineByFacultyID (Long id);

}
