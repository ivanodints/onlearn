package ru.portal.onlearn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "discipline")
public class Discipline implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "disc_title", nullable = false, unique = true)
    private String title;

    @Column(name = "disc_time", nullable = false)
    private LocalTime disc_time;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "fac_disc",
    joinColumns = @JoinColumn(name = "fac_id"),
    inverseJoinColumns = @JoinColumn(name = "disc_id"))
    private Set<Faculty> faculty;

    public Discipline() {
    }

    public Discipline(String title, LocalTime disc_time) {
        this.title = title;
        this.disc_time = disc_time;
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

    public LocalTime getDisc_time() {
        return disc_time;
    }

    public void setDisc_time(LocalTime disc_time) {
        this.disc_time = disc_time;
    }

    public Set<Faculty> getFaculty() {
        return faculty;
    }

    public void setFaculty(Set<Faculty> faculty) {
        this.faculty = faculty;
    }
}
