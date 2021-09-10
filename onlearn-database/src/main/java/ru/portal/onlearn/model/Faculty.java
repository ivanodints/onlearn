package ru.portal.onlearn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "faculty")
@Getter
@Setter
@NoArgsConstructor
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
//
//    @ManyToMany(mappedBy = "fac_student")
//    @JoinColumn(name = "fac_id")
//    private List<Student> students;
//
//    @ManyToMany(mappedBy = "sphere_fac")
//    @JoinColumn(name = "fac_id")
//    private List<SphereOfActivities> sphereOfActivitiesFaculty;


}
