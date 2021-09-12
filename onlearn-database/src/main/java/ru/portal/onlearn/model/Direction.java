package ru.portal.onlearn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "directions")
@Getter
@Setter
@NoArgsConstructor
public class Direction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "direction_title", nullable = false)
    private String title;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "direction_fac",
    joinColumns = @JoinColumn(name = "direction_id"),
    inverseJoinColumns = @JoinColumn(name = "fac_id"))
    private List<Faculty> faculties;

//    @OneToMany(mappedBy = "directions",
//    cascade = CascadeType.ALL)
//    private List<Faculty> faculties;

//    public List<String> getFacultiesTitles(){
//        return faculties.stream().map(p -> p.getTitle()).collect(Collectors.toList());
//    }

    // Возможно не нужна
//    @ManyToMany(mappedBy = "direction_fac")
//    @JoinColumn(name = "direction_id")
//    private List<Faculty> directionFaculty;

    public Direction(Long id, String title) {
        this.id = id;
        this.title = title;
    }

}
