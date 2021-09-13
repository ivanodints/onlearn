package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.portal.onlearn.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
