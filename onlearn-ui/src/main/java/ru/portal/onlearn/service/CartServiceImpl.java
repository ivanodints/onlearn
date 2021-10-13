package ru.portal.onlearn.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.FacultyDTO;
import ru.portal.onlearn.controller.DTO.OrderDTO;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.model.Order;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.repo.OrderRepository;
import ru.portal.onlearn.repo.StudentRepository;
import ru.portal.onlearn.service.model.LineItem;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartServiceImpl implements CartService, Serializable {

    private final Map<LineItem, Integer> lineItems;
    private final OrderRepository orderRepository;
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    public CartServiceImpl(OrderRepository orderRepository, StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.orderRepository = orderRepository;
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
        this.lineItems = new HashMap<>();
    }

//    @JsonCreator
//    public CartServiceImpl(@JsonProperty("lineItems")List<LineItem> lineItems){
//        this.lineItems = lineItems.stream().collect(Collectors.toMap(li -> li, LineItem::getQty));
//    }

    @Override
    public void addFaculty(FacultyDTO facultyDTO) {
        LineItem lineItem = new LineItem(facultyDTO);
        String title = lineItem.getFacultyDTO().getTitle();
        Integer exist = 0;
        Iterator iterator = lineItems.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            LineItem key = (LineItem) entry.getKey();
            String title1 = key.getFacultyDTO().getTitle();
            if(title.equals(title1)){
                exist = 1;
            }
        }

        if(exist == 0){
            lineItems.put(lineItem, lineItems.getOrDefault(lineItem, 0) + 1);
        }
    }

    @Override
    public void removeFaculty(Long facultyId) {
        Iterator iterator = lineItems.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            LineItem key = (LineItem) entry.getKey();
            Long id1 = key.getFacultyDTO().getId();
            if (id1 == facultyId) {
                lineItems.remove(key);
                break;
            }
        }
    }

    @Override
    public List<LineItem> getLineItems() {
        return new ArrayList<>(lineItems.keySet());
    }

    @Override
    public BigDecimal totalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        Iterator iterator = lineItems.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            LineItem key = (LineItem) entry.getKey();
            totalPrice = (totalPrice).add(key.getFacultyDTO().getPrice());
        }
        return totalPrice;
    }

    @Override
    public Set<Faculty> getFacultyList() {
        Set<Faculty> facultySet = new HashSet<>();
        Iterator iterator = lineItems.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            LineItem key = (LineItem) entry.getKey();
            facultySet.add(facultyRepository.findByTitle(key.getFacultyDTO().getTitle()));
        }
        return facultySet;
    }

    @Override
    public void saveToOrder() {
        Order order = new Order();
        order.setStudent(studentRepository.findBySurname("Семенов"));
        order.setFaculty(getFacultyList());
        orderRepository.save(order);
        lineItems.clear();
    }


}
