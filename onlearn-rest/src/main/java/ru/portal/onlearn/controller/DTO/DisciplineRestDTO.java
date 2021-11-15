package ru.portal.onlearn.controller.DTO;


import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Faculty;

@Getter
@Setter
@NoArgsConstructor
public class DisciplineRestDTO implements Serializable {

    private Long id;

    private String title;

    private LocalTime discTime;

    private String description;

    private Set<Faculty> faculty;

    public DisciplineRestDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public DisciplineRestDTO(Long id, String title, LocalTime discTime, String description) {
        this.id = id;
        this.title = title;
        this.discTime = discTime;
        this.description = description;
    }

    public DisciplineRestDTO(Long id, String title, LocalTime discTime, String description, Set<Faculty> faculty) {
        this.id = id;
        this.title = title;
        this.discTime = discTime;
        this.description = description;
        this.faculty = faculty;
    }

    public DisciplineRestDTO(Discipline discipline) {
        this.id = discipline.getId();
        this.title = discipline.getTitle();
        this.discTime = discipline.getDiscTime();
        this.description = discipline.getDescription();
        this.faculty = discipline.getFaculty();
    }


}
