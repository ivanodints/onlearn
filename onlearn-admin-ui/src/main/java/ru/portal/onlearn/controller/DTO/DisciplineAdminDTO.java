package ru.portal.onlearn.controller.DTO;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.model.Faculty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisciplineAdminDTO implements Serializable {

    private Long id;

    private String title;

    private LocalTime discTime;

    private String description;

    private Set<Faculty> faculty;

    private Set<Employee> employees;


    public DisciplineAdminDTO(Discipline discipline) {
        this.id = discipline.getId();
        this.title = discipline.getTitle();
        this.discTime = discipline.getDiscTime();
        this.description = discipline.getDescription();
        this.faculty = discipline.getFaculty();
        this.employees = discipline.getEmployees();
    }

}
