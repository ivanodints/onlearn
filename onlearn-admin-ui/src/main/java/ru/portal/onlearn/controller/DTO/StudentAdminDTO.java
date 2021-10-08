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

    private List<Faculty> faculty;

    private List<PictureDTO> pictures;

    private MultipartFile[] newPictures;

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
//        this.faculty = student.getFaculty();
    }
}
