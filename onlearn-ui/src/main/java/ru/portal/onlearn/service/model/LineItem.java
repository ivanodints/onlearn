package ru.portal.onlearn.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.controller.DTO.FacultyDTO;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineItem implements Serializable {

    private Long facultyId;

    private FacultyDTO facultyDTO;

    public LineItem(FacultyDTO facultyDTO) {
        this.facultyDTO = facultyDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Objects.equals(facultyDTO, lineItem.facultyDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyDTO);
    }
}
