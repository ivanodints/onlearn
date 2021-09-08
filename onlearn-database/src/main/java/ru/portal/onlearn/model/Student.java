//package ru.portal.onlearn.model;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//@Table(name = "student")
//@Getter
//@Setter
//@NoArgsConstructor
//public class Student  implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "surname", nullable = false)
//    private String surname;
//
//    @Column(name = "middle_name", nullable = false)
//    private String middle_name;
//
//    @Column(name = "date_of_birth", nullable = false)
//    private LocalDate date_of_birth;
//
//    @Column(name = "sex", nullable = false)
//    private String sex;
//
//    @Column(name = "email", nullable = false, unique = true)
//    private String email;
//
//    @Column(name = "phone_number", nullable = false, unique = true)
//    private String phone_number;
//
//    @ManyToOne(optional = false)
//    private Role roles;
//
////    @ManyToMany(mappedBy = "fac_student")
////    @JoinColumn(name = "student_id")
////    private List<Faculty> faculties;
//
//    public Student(Long id, String name, String surname,
//                   String middle_name, LocalDate date_of_birth, String sex, String email, String phone_number) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.middle_name = middle_name;
//        this.date_of_birth = date_of_birth;
//        this.sex = sex;
//        this.email = email;
//        this.phone_number = phone_number;
//    }
//}
