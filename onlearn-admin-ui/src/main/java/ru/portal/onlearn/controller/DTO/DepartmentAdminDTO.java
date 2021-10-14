package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.Validation.ContactNullConstraint;
import ru.portal.onlearn.model.Department;
import ru.portal.onlearn.model.Employee;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentAdminDTO implements Serializable {

    private Long id;

    @ContactNullConstraint
    private String title;

    private List<Employee> employees;

    public DepartmentAdminDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public DepartmentAdminDTO(Department department){
        this.id = department.getId();
        this.title = department.getTitle();
        this.employees = department.getEmployees();
    }
}
