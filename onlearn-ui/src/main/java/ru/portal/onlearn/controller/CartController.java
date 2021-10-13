package ru.portal.onlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.controller.DTO.FacultyDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Order;
import ru.portal.onlearn.repo.OrderRepository;
import ru.portal.onlearn.service.CartService;
import ru.portal.onlearn.service.DirectionService;
import ru.portal.onlearn.service.FacultyService;
import ru.portal.onlearn.service.model.LineItem;

@Controller
@RequestMapping("/cart")
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    public final CartService cartService;
    public final DirectionService directionService;
    public final FacultyService facultyService;
    public final OrderRepository orderRepository;

    @Autowired
    public CartController(CartService cartService, DirectionService directionService, FacultyService facultyService, OrderRepository orderRepository) {
        this.cartService = cartService;
        this.directionService = directionService;
        this.facultyService = facultyService;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("lineItems", cartService.getLineItems());
        model.addAttribute("totalPrice",cartService.totalPrice());
        model.addAttribute("allDirection", directionService.findAllDirection());
        model.addAttribute("facultyAll",facultyService.findAllFaculty());
        return "shopping-cart";
    }

    @PostMapping
    public String addToCart(LineItem lineItem){
        FacultyDTO facultyDTO = facultyService.findFacultyById(lineItem.getFacultyId())
                .orElseThrow(NotFoundException::new);
        cartService.addFaculty(facultyDTO);
        cartService.totalPrice();
        return "redirect:/cart";
    }

    @DeleteMapping
    public String delete(@RequestParam("facultyId") Long facultyId){
        cartService.removeFaculty(facultyId);
        return "redirect:/cart";
    }

    @PostMapping("/saveToOrder")
    @Transactional
    public String addToOrder(Model model){
        model.addAttribute("lineItems", cartService.getLineItems());
        model.addAttribute("totalPrice",cartService.totalPrice());
        model.addAttribute("allDirection", directionService.findAllDirection());
        model.addAttribute("facultyAll",facultyService.findAllFaculty());
        cartService.saveToOrder();
        return "thankyou";
    }

}
