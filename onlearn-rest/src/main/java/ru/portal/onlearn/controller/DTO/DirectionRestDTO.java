package ru.portal.onlearn.controller.DTO;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Direction;

@Getter
@Setter
@NoArgsConstructor
public class DirectionRestDTO implements Serializable {

    private Long id;

    private String title;

    private String description;

    private Long facultyId;

    private List<Long> facultyIds;


    public DirectionRestDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public DirectionRestDTO(Direction direction) {
        this.id = direction.getId();
        this.title = direction.getTitle();
        this.description = direction.getDescription();
    }
}
