package ru.portal.onlearn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "discipline")
@Getter
@Setter
@NoArgsConstructor
public class Discipline implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "disc_title", nullable = false, unique = true)
    private String title;

    @Column(name = "disc_time", nullable = false)
    private LocalTime disc_time;

    @Column(name = "description")
    private  String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "fac_disc",
    joinColumns = @JoinColumn(name = "disc_id"),
    inverseJoinColumns = @JoinColumn(name = "fac_id"))
    private Set<Faculty> faculty;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "employee_disc",
            joinColumns = @JoinColumn(name = "disc_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> employees;

    public Discipline(String title, LocalTime disc_time, String description) {
        this.title = title;
        this.disc_time = disc_time;
        this.description = description;
    }

}
