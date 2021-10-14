package ru.portal.onlearn.controller.DTO;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import ru.portal.onlearn.Validation.ContactNullConstraint;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.model.Faculty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisciplineAdminDTO implements Serializable {

    private Long id;

    @ContactNullConstraint
    private String title;

    private LocalTime discTime;

    @ContactNullConstraint
    private String description;

    private Set<Faculty> faculty;

    private Set<Employee> employees;

    private List<PictureDTO> pictures;

    private MultipartFile[] newPictures;


    public DisciplineAdminDTO(Discipline discipline) {
        this.id = discipline.getId();
        this.title = discipline.getTitle();
        this.discTime = discipline.getDiscTime();
        this.description = discipline.getDescription();
        this.faculty = discipline.getFaculty();
        this.employees = discipline.getEmployees();
    }

    public DisciplineAdminDTO(Long id, String title, LocalTime discTime, String description,
                              Set<Faculty> faculty, List<PictureDTO> pictures) {
        this.id = id;
        this.title = title;
        this.discTime = discTime;
        this.description = description;
        this.faculty = faculty;
        this.pictures = pictures;
    }

    public DisciplineAdminDTO(Long id, String title, LocalTime discTime, String description,
                              Set<Faculty> faculty, Set<Employee> employees, List<PictureDTO> pictures) {
        this.id = id;
        this.title = title;
        this.discTime = discTime;
        this.description = description;
        this.faculty = faculty;
        this.employees = employees;
        this.pictures = pictures;
    }

    public DisciplineAdminDTO(Long id, String title, LocalTime discTime,
                              String description, List<PictureDTO> pictureDTO) {
        this.id = id;
        this.title = title;
        this.discTime = discTime;
        this.description = description;
        this.pictures = pictureDTO;
    }

    public String getFacultyTitle() {
        if (faculty != null) {
            return faculty.stream().map(faculty -> faculty.getTitle()).collect(Collectors.joining(", "));
        }
        return null;
    }
}
