package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Employee;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    private String name;

    private String surname;

    private String middleName;

    private LocalDate dateOfBirth;

    private String sex;

    private String email;

    private String phoneNumber;

    private String bio;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.surname = employee.getSurname();
        this.middleName = employee.getMiddleName();
        this.dateOfBirth = employee.getDateOfBirth();
        this.sex = employee.getSex();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.bio = employee.getBio();
    }
}
