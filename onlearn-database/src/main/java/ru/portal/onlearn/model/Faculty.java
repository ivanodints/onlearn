package ru.portal.onlearn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "faculties")
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

//    @ManyToOne(optional = false)
//    private Direction direction;

    @ManyToMany(mappedBy = "faculty")
    private List<Discipline> disciplines;
//
//    @ManyToMany(mappedBy = "fac_student")
//    @JoinColumn(name = "fac_id")
//    private List<Student> students;
//
//    @ManyToOne(mappedBy = "direction_fac")
//    @JoinColumn(name = "fac_id")
//    private List<Direction> directionFaculty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "direction_fac",
            joinColumns = @JoinColumn(name = "direction_id"),
            inverseJoinColumns = @JoinColumn(name = "fac_id"))
    private Direction direction;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "fac_students",
            joinColumns = @JoinColumn(name = "fac_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

}
