package ru.portal.onlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.portal.onlearn.model.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeesById (Long Id);
}
