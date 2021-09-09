package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.portal.onlearn.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
