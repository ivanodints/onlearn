package ru.portal.onlearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.Validation.ContactNameConstraint;
import ru.portal.onlearn.Validation.ContactNumberConstraint;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ContactNameConstraint
    @Column(name = "name", nullable = false)
    private String name;

    @ContactNameConstraint
    @Column(name = "surname", nullable = false)
    private String surname;

    @ContactNameConstraint
    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Email (message = "Email должен быть корректным адресом электронной почты")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ContactNumberConstraint
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column (name = "bio")
    private String bio;

    @ManyToMany(mappedBy = "employees")
    private List<Discipline> disciplines;

    @ManyToOne(optional = true)
    private Department department;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private User user;


    public Employee(Long id, String name, String surname,
                    String middleName, Date dateOfBirth, String sex, String email, String phoneNumber, String bio,
                    User user) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.user = user;
    }

}
