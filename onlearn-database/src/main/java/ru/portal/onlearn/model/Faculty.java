package ru.portal.onlearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "faculty")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Faculty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false)
    private Direction direction;

    @ManyToMany(mappedBy = "faculty")
    private Set<Discipline> disciplines;

    @ManyToMany(mappedBy = "faculty")
    private Set<Student> students;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Picture> pictures;

    public Faculty(Long id, String title, BigDecimal price, String description) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public Faculty(Long id, String title, BigDecimal price, String description, Direction direction) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.direction = direction;
    }

    public Faculty(Long id, String title, BigDecimal price, String description, Direction direction, List<Picture> pictures) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.direction = direction;
        this.pictures = pictures;
    }
}
