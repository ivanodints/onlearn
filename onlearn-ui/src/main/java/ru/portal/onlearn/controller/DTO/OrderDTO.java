package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Order;
import ru.portal.onlearn.model.Student;
import ru.portal.onlearn.service.model.LineItem;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;

//    private Date dateOfOrder;

    private Student student;

    private Set<Faculty> faculty;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.student = order.getStudent();
        this.faculty = order.getFaculty();
    }

//    public OrderDTO(LineItem lineItem){
//        this.
//    }
}
