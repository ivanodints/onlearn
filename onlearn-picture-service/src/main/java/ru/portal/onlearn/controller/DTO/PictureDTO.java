package ru.portal.onlearn.controller.DTO;

import lombok.Getter;
import lombok.Setter;
import ru.portal.onlearn.model.Picture;

import java.io.Serializable;


@Getter
@Setter
public class PictureDTO implements Serializable {
    private Long id;

    private String title;

    private String contentType;

    public PictureDTO(Picture picture) {
        this.id = picture.getId();
        this.title = picture.getTitle();
        this.contentType = picture.getContentType();
    }
}
