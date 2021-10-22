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

    @Query("select st from Student st where (st.id=:student_id or :student_id is null)")
    Student findById (@Param("student_id") Integer id);


    @Query("select st from Student st inner join User u on st.user.id = u.id  where (u.login=:student_user_login or :student_user_login is null)")
    Student findByUserLogin (@Param("student_user_login") String login);
}
