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
public class DirectionDTO implements Serializable {

    private Long id;

    private String title;

    private String description;

    private Long facultyId;

    private List<Long> facultyIds;

    private  Long pictureId;

    private  List<Long> pictureIds;

    public DirectionDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public DirectionDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public DirectionDTO(Long id, String title, String description, Long facultyId, List<Long> facultyIds,
                        Long pictureId, List<Long> pictureIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.facultyId = facultyId;
        this.facultyIds = facultyIds;
        this.pictureId = pictureId;
        this.pictureIds = pictureIds;
    }

    public DirectionDTO(Direction direction) {
        this.id = direction.getId();
        this.title = direction.getTitle();
        this.description = direction.getDescription();
    }

}
