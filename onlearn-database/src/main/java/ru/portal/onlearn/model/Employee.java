package ru.portal.onlearn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column (name = "bio")
    private String bio;

    @ManyToMany(mappedBy = "employees")
    private Set<Discipline> disciplines;

    @ManyToOne(optional = false)
    private Role role;

    @ManyToOne(optional = true)
    private Department department;

//    @ManyToMany(mappedBy = "fac_student")
//    @JoinColumn(name = "fac_id")
//    private List<Departments> emplDepartments;



    public Employee(Long id, String name, String surname,
                    String middleName, LocalDate dateOfBirth, String sex, String email, String phoneNumber, String bio) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
    }

}
