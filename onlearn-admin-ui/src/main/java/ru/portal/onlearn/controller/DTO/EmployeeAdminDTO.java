package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.Validation.ContactNameConstraint;
import ru.portal.onlearn.Validation.ContactNullConstraint;
import ru.portal.onlearn.Validation.ContactNumberConstraint;
import org.springframework.web.multipart.MultipartFile;
import ru.portal.onlearn.Validation.ContactSexConstraint;
import ru.portal.onlearn.model.Department;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.model.User;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAdminDTO implements Serializable {

    private Long id;

    @ContactNullConstraint
    @ContactNameConstraint
    private String name;

    @ContactNullConstraint
    @ContactNameConstraint
    private String surname;

    @ContactNullConstraint
    @ContactNameConstraint
    private String middleName;

    private Date dateOfBirth;

    @ContactSexConstraint
    private String sex;

    @Email
    private String email;

    @ContactNumberConstraint
    private String phoneNumber;

    private User user;

    private Department department;

    private String bio;

    private List<PictureDTO> pictures;

    private MultipartFile[] newPictures;

    public EmployeeAdminDTO(Long id, String name, String surname, String middleName, Date dateOfBirth,
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

    public EmployeeAdminDTO(Long id, String name, String surname, String middleName, Date dateOfBirth,
                            String sex, String email, String phoneNumber, User user, Department department,
                            String bio, List<PictureDTO> pictures) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.user = user;
        this.department = department;
        this.bio = bio;
        this.pictures = pictures;
    }

    public EmployeeAdminDTO(Long id, String name, String surname, String middleName, Date dateOfBirth,
                            String sex, String email, String phoneNumber, Department department, String bio,
                            List<PictureDTO> pictures) {
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
        this.pictures = pictures;
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
        this.user = employee.getUser();
        this.department = employee.getDepartment();
        this.bio = employee.getBio();
    }

    public String getDepartmentTitle() {
        if (department != null) {
            return department.getTitle();
        }
        return null;
    }

}
