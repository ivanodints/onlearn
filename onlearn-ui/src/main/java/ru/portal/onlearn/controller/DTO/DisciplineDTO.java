package ru.portal.onlearn.controller.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Discipline;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisciplineDTO {

    private Long id;

    private String title;

    private LocalTime disc_time;

    private  String description;

    public DisciplineDTO(Discipline discipline) {
        this.id = discipline.getId();
        this.title = discipline.getTitle();
        this.disc_time = discipline.getDisc_time();
        this.description = discipline.getDescription();
    }
}
