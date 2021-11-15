package ru.portal.onlearn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "discipline")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discipline implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "disc_title", nullable = false, unique = true)
    private String title;

    @Column(name = "disc_time", nullable = false)
    private LocalTime discTime;

    @Column(name = "description")
    private  String description;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "fac_disc",
    joinColumns = @JoinColumn(name = "disc_id"),
    inverseJoinColumns = @JoinColumn(name = "fac_id"))
    private Set<Faculty> faculty;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "employee_disc",
            joinColumns = @JoinColumn(name = "disc_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> employees;

    @JsonIgnore
    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL)
    private List<Picture> pictures;


    public Discipline(Long id, String title, LocalTime discTime, String description) {
        this.id = id;
        this.title = title;
        this.discTime = discTime;
        this.description = description;
    }

    public Discipline(Long id, String title, LocalTime discTime, String description, List<Picture> pictures) {
        this.id = id;
        this.title = title;
        this.discTime = discTime;
        this.description = description;
        this.pictures = pictures;
    }
}
