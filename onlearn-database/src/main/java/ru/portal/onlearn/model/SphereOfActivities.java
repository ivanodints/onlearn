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
@Table(name = "sphere_of_activities" )
@Getter
@Setter
@NoArgsConstructor
public class SphereOfActivities implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sphereTitle", nullable = false)
    private String title;

    @OneToMany(mappedBy = "sphereOfActivities",
    cascade = CascadeType.ALL)
    private List<Faculty> faculties;

    public List<String> getFacultiesTitles(){
        return faculties.stream().map(p -> p.getTitle()).collect(Collectors.toList());
    }


    // Возможно не нужна
//    @ManyToMany(mappedBy = "sphere_fac")
//    @JoinColumn(name = "sphere_id")
//    private List<Faculty> sphereFaculty;


    public SphereOfActivities(Long id, String title) {
        this.id = id;
        this.title = title;
    }

}
