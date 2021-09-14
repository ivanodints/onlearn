package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Role;
import ru.portal.onlearn.model.Student;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements Serializable {

    private Long id;

    private String name;

    private String surname;

    private String middleName;

    private LocalDate dateOfBirth;

    private String sex;

    private String email;

    private String phoneNumber;

    private Role role;

    private List<Faculty> faculty;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.surname = student.getSurname();
        this.middleName = student.getMiddleName();
        this.dateOfBirth = student.getDateOfBirth();
        this.sex = student.getSex();
        this.email = student.getEmail();
        this.phoneNumber = student.getPhoneNumber();
        this.role = student.getRole();
//        this.faculty = student.getFaculty();
    }
}
