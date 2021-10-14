package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import ru.portal.onlearn.Validation.ContactNullConstraint;
import ru.portal.onlearn.model.Direction;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DirectionAdminDTO implements Serializable {

    private Long id;

    @ContactNullConstraint
    private String title;

    @ContactNullConstraint
    private String description;

    private List<PictureDTO> pictures;

    private MultipartFile[] newPictures;

    public DirectionAdminDTO(Long id, String title, String description, List<PictureDTO> pictureDTO) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pictures = pictureDTO;
    }

    public DirectionAdminDTO(Direction direction) {
        this.id = direction.getId();
        this.title = direction.getTitle();
        this.description = direction.getDescription();
    }



}
