package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.portal.onlearn.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select d from Role d where (d.title like :title or :title is null)")
    Role findByTitle (@Param("title") String title);

}
