package ru.portal.onlearn.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "pictures")
@Getter
@Setter
@NoArgsConstructor
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content_type", nullable = false)
    private String contentType;

    @OneToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name="picture_data_id")
    private PictureData pictureData;

    @ManyToOne
    private Discipline discipline;

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private Direction direction;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Student student;

    public Picture(String title, String contentType, PictureData pictureData, Discipline discipline) {
        this.title = title;
        this.contentType = contentType;
        this.pictureData = pictureData;
        this.discipline = discipline;
    }

    public Picture(String title, String contentType, PictureData pictureData, Faculty faculty) {
        this.title = title;
        this.contentType = contentType;
        this.pictureData = pictureData;
        this.faculty = faculty;
    }

    public Picture(String title, String contentType, PictureData pictureData, Direction direction) {
        this.title = title;
        this.contentType = contentType;
        this.pictureData = pictureData;
        this.direction = direction;
    }

    public Picture(String title, String contentType, PictureData pictureData, Employee employee) {
        this.title = title;
        this.contentType = contentType;
        this.pictureData = pictureData;
        this.employee = employee;
    }

    public Picture(String title, String contentType, PictureData pictureData, Student student) {
        this.title = title;
        this.contentType = contentType;
        this.pictureData = pictureData;
        this.student = student;
    }
}
