package ru.portal.onlearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student  implements Serializable {

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
    private Date dateOfBirth;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Size(min = 11, max = 12)
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_fac",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id"))
    private Set<Faculty> faculty;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Picture> pictures;

    public Student(Long id, String name, String surname,
                   String middleName, Date dateOfBirth, String sex, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Student(Long id, String name, String surname, String middleName, Date dateOfBirth, String sex,
                   @Email String email, @Size(min = 11, max = 12) String phoneNumber, List<Picture> pictures) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pictures = pictures;
    }

    public Student(Long id, String name, String surname, String middleName, Date dateOfBirth, String sex,
                   @Email String email, @Size(min = 11, max = 12) String phoneNumber, User user, List<Picture> pictures) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.user = user;
        this.pictures = pictures;
    }
}
