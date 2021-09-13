package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Direction;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DirectionAdminDTO implements Serializable {

    private Long id;

    private String title;

    private String description;

    private Long facultyId;

    private List<Long> facultyIds;

    public DirectionAdminDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public DirectionAdminDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public DirectionAdminDTO(Direction direction) {
        this.id = direction.getId();
        this.title = direction.getTitle();
        this.description = direction.getTitle();
    }

}
