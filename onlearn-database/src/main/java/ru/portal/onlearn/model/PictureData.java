package ru.portal.onlearn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "pictures_data")
@Getter
@Setter
@NoArgsConstructor
public class PictureData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "data", length = 33554430) // для правильной hibernate-валидации в MySQL
    private byte[] data;

    @Column(name = "file_name")
    private String fileName;

    public PictureData(byte[] data) {
        this.data = data;
    }

    public PictureData(String fileName) {
        this.fileName = fileName;
    }

}
