package ru.portal.onlearn.controller.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Department;
import ru.portal.onlearn.model.Role;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO implements Serializable {

    private Long id;

    private String name;

    private String surname;

    private String middleName;

    private LocalDate dateOfBirth;

    private String sex;

    private String email;

    private String phoneNumber;

    private Role role;

    private Department department;

    public EmployeeDTO(Long id, String name, String surname, String middleName, LocalDate dateOfBirth,
                       String sex, String email, String phoneNumber, Department department) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }


}
