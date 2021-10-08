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
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.model.Faculty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisciplineAdminDTO implements Serializable {

    private Long id;

    private String title;

    private LocalTime discTime;

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
    }

    public DisciplineAdminDTO(Long id, String title, LocalTime discTime, String description, List<PictureDTO> pictureDTO) {
        this.id = id;
        this.title = title;
        this.discTime = discTime;
        this.description = description;
        this.pictures = pictureDTO;
    }

    public String getFacultyTitle (){
        return faculty.stream().map(faculty1 -> faculty1.getTitle()).collect(Collectors.joining(", "));
    }

}
