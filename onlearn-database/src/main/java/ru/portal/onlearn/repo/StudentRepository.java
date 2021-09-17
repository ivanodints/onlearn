package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select st from Student st where (st.surname like :surname or :surname is null)")
    Student findBySurname (@Param("surname") String surname);
}
