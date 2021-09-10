package ru.portal.onlearn.model;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class SphereOfActivities implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sphereTitle", nullable = false)
    private String title;

    @Column(name = "description")
    private  String description;

    @OneToMany(mappedBy = "sphereOfActivities",
    cascade = CascadeType.ALL)
    private List<Faculty> faculties;

    //Нужно ли переносить в сервисы?
    public List<String> getFacultiesTitles(){
        return faculties.stream().map(p -> p.getTitle()).collect(Collectors.toList());
    }


    public SphereOfActivities(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

}
