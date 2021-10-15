package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.portal.onlearn.model.Department;
import ru.portal.onlearn.model.Role;
import ru.portal.onlearn.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByLogin(String name);

    boolean existsUserByLogin(String login);

}
