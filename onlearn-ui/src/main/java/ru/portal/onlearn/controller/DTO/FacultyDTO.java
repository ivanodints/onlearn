package ru.portal.onlearn.controller.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Faculty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyDTO {

    private Long id;

    private String title;

    private BigDecimal price;

    private  String description;

    public FacultyDTO(Faculty faculty) {
        this.id = faculty.getId();
        this.title = faculty.getTitle();
        this.price = faculty.getPrice();
        this.description = faculty.getDescription();
    }
}
