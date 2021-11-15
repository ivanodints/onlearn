package ru.portal.onlearn.controller.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Faculty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyRestDTO implements Serializable {

    private Long id;

    private String title;

    private BigDecimal price;

    private String description;

    private Direction direction;

    public FacultyRestDTO(Long id, String title, BigDecimal price, String description) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public FacultyRestDTO(Faculty faculty) {
        this.id = faculty.getId();
        this.title = faculty.getTitle();
        this.price = faculty.getPrice();
        this.description = faculty.getDescription();
        this.direction = faculty.getDirection();
    }


}
