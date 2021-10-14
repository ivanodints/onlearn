package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import ru.portal.onlearn.Validation.ContactNullConstraint;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Student;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacultyAdminDTO implements Serializable {

    private Long id;

    @ContactNullConstraint
    private String title;

    private BigDecimal price;

    @ContactNullConstraint
    private String description;

    private Direction direction;

    private List<PictureDTO> pictures;

    private MultipartFile[] newPictures;

    public FacultyAdminDTO(Long id, String title, BigDecimal price, String description, List<PictureDTO> pictureDTO) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.pictures = pictureDTO;
    }

    public FacultyAdminDTO(Long id, String title, BigDecimal price, String description, Direction direction, List<PictureDTO> pictures) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.direction = direction;
        this.pictures = pictures;
    }


    public FacultyAdminDTO(Faculty faculty) {
        this.id = faculty.getId();
        this.title = faculty.getTitle();
        this.price = faculty.getPrice();
        this.description = faculty.getDescription();
        this.direction = faculty.getDirection();
    }
}
