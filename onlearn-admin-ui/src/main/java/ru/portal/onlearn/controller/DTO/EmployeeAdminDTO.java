package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Department;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.model.Role;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAdminDTO implements Serializable {

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

    private String bio;

    public EmployeeAdminDTO(Long id, String name, String surname, String middleName, LocalDate dateOfBirth,
                       String sex, String email, String phoneNumber, Department department, String bio) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.bio = bio;
    }

    public EmployeeAdminDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.surname = employee.getSurname();
        this.middleName = employee.getMiddleName();
        this.dateOfBirth = employee.getDateOfBirth();
        this.sex = employee.getSex();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.role = employee.getRole();
        this.department = employee.getDepartment();
        this.bio = employee.getBio();
    }
}
