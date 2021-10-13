package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Role;
import ru.portal.onlearn.model.Student;
import ru.portal.onlearn.model.User;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentAdminDTO implements Serializable {

    private Long id;

    private String name;

    private String surname;

    private String middleName;

    private Date dateOfBirth;

    private String sex;

    private String email;

    private String phoneNumber;

    private User user;

    private Set<Faculty> faculty;

    private List<PictureDTO> pictures;

    private MultipartFile[] newPictures;


    public StudentAdminDTO(Long id, String name, String surname, String middleName, Date dateOfBirth, String sex,
                           String email, String phoneNumber, Set<Faculty> faculty, List<PictureDTO> pictures) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.pictures = pictures;
    }

    public StudentAdminDTO(Long id, String name, String surname, String middleName, Date dateOfBirth, String sex,
                           String email, String phoneNumber, User user, List<PictureDTO> pictures) {
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

    public StudentAdminDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.surname = student.getSurname();
        this.middleName = student.getMiddleName();
        this.dateOfBirth = student.getDateOfBirth();
        this.sex = student.getSex();
        this.email = student.getEmail();
        this.phoneNumber = student.getPhoneNumber();
        this.user = student.getUser();
        this.faculty = student.getFaculty();
    }

    public StudentAdminDTO(Long id, String name, String surname, String middleName, Date dateOfBirth, String sex,
                           String email, String phoneNumber, List<PictureDTO> pictures) {
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
}
