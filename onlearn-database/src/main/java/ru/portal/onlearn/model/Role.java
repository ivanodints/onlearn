package ru.portal.onlearn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "web_roles")
@Getter
@Setter
@NoArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

//    @OneToMany(mappedBy = "roles",
//            cascade = CascadeType.ALL)
//    private List<Employee> employee;

    @OneToMany(mappedBy = "roles",
            cascade = CascadeType.ALL)
    private List<Student> students;

}
