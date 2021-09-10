package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.SphereOfActivities;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

// аннотации геттеры, сеттеры, конструкторы это всё lombok. Он автогенерить будет для уменьшения написания кода
// если что пишите поясню

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SphereOfActivitiesDTO implements Serializable {


    private Long id;

    private String title;

    private Long facultyId;

    private List<Long> facultyIds;


    public SphereOfActivitiesDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public SphereOfActivitiesDTO(SphereOfActivities sphereOfActivities) {
        this.id = sphereOfActivities.getId();
        this.title = sphereOfActivities.getTitle();
    }
}