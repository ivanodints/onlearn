package ru.portal.onlearn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sphere_of_activities")
public class SphereOfActivities implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sphere_title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "sphere_fac",
    cascade = CascadeType.ALL)
    private List<Faculty> faculties;

    @ManyToMany(mappedBy = "sphere_fac")
    @JoinColumn(name = "sphere_id")
    private List<Faculty> sphereFaculty;

    public SphereOfActivities() {
    }

    public SphereOfActivities(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Faculty> getSphereFaculty() { return sphereFaculty; }

    public void setSphereFaculty(List<Faculty> sphereFaculty) { this.sphereFaculty = sphereFaculty; }

    @Override
    public boolean equals(Object o){
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass()) return false;
        SphereOfActivities sphereOfActivities = (SphereOfActivities) o;
        return id.equals(sphereOfActivities.id) && title.equals(sphereOfActivities.title);
    }

    @Override
    public int hashCode() { return Objects.hash(id, title); }
}
