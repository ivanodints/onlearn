package ru.portal.onlearn.service;

import ru.portal.onlearn.controller.DTO.FacultyDTO;
import ru.portal.onlearn.controller.DTO.OrderDTO;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.service.model.LineItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface CartService {

    void addFaculty(FacultyDTO facultyDTO);

    void removeFaculty(Long facultyId);

    List<LineItem> getLineItems();

    BigDecimal totalPrice();

    Set<Faculty> getFacultyList();

//    void saveToOrder(OrderDTO orderDTO);
    void saveToOrder();
}
