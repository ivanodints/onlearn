package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Direction;


import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DirectionDTO implements Serializable {


    private Long id;

    private String title;

    private String description;

    private Long facultyId;

    private List<Long> facultyIds;

    public DirectionDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public DirectionDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public DirectionDTO(Direction direction) {
        this.id = direction.getId();
        this.title = direction.getTitle();
        this.description = direction.getDescription();
    }

}
