package ru.portal.onlearn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "departments")
public class Departments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dept_title", nullable = false)
    private String title;

    public Departments() {
    }

    @OneToMany(mappedBy = "departments",
    cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Departments(String title) {
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

}
