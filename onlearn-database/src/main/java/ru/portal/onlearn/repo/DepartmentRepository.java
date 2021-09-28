package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.portal.onlearn.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("select d from Department d where (d.title like :title or :title is null)")
    Department findByTitle (@Param("title") String title);

}
