package ru.portal.onlearn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne(optional = false)
    private SphereOfActivities sphereOfActivities;

    @ManyToMany(mappedBy = "faculty")
    private List<Discipline> disciplines;

    public Faculty() {
    }

    public Faculty(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public SphereOfActivities getSphereOfActivities() {
        return sphereOfActivities;
    }

    public void setSphereOfActivities(SphereOfActivities sphereOfActivities) {
        this.sphereOfActivities = sphereOfActivities;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

}
