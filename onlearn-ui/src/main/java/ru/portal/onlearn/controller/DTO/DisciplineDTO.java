package ru.portal.onlearn.controller.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.model.Faculty;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DisciplineDTO implements Serializable {

    private Long id;

    private String title;

    private LocalTime discTime;

    private String description;

    private Set<Faculty> faculty;

    private Set<Employee> employees;

    public DisciplineDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public DisciplineDTO(Long id, String title, LocalTime discTime, String description) {
        this.id = id;
        this.title = title;
        this.discTime = discTime;
        this.description = description;
    }

    public DisciplineDTO(Discipline discipline) {
        this.id = discipline.getId();
        this.title = discipline.getTitle();
        this.discTime = discipline.getDiscTime();
        this.description = discipline.getDescription();
        this.faculty = discipline.getFaculty();
        this.employees = discipline.getEmployees();
    }

}
