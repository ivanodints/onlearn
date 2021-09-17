package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Student;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyAdminDTO implements Serializable {

    private Long id;

    private String title;

    private BigDecimal price;

    private String description;

    private Direction direction;

    public FacultyAdminDTO(Faculty faculty) {
        this.id = faculty.getId();
        this.title = faculty.getTitle();
        this.price = faculty.getPrice();
        this.description = faculty.getDescription();
        this.direction = faculty.getDirection();
    }
}
