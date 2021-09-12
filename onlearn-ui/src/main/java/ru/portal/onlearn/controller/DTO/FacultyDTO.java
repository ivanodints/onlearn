package ru.portal.onlearn.controller.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Student;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyDTO {

    private Long id;

    private String title;

    private BigDecimal price;

    private List<Discipline> disciplines;

    private Direction direction;

    private List<Student> students;

    public FacultyDTO(Long id, String title, BigDecimal price, Direction direction, List<Discipline> disciplines, List<Student> students) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.direction = direction;
        this.disciplines = disciplines;
        this.students = students;
    }

    public FacultyDTO(Long id, String title, BigDecimal price, Direction direction, List<Student> students) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.direction = direction;
        this.students = students;
    }

//    public FacultyDTO(Faculty faculty) {
//        this.id = faculty.getId();
//        this.title = faculty.getTitle();
//        this.price = faculty.getPrice();
//        this.disciplines = faculty.getDisciplines();
//    }
}
