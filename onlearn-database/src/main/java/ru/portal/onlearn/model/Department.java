package ru.portal.onlearn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dept_title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "department",
            cascade = CascadeType.ALL)
    private List<Employee> employees;

//    @ManyToMany(mappedBy = "dept_employee")
//    @JoinColumn(name = "dept_id")
//    private List<Employee> depEmployee;

}
