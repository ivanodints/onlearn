package ru.portal.onlearn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.controller.DTO.StudentDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.User;
import ru.portal.onlearn.repo.StudentRepository;
import ru.portal.onlearn.repo.UserRepository;
import ru.portal.onlearn.service.StudentService;
import ru.portal.onlearn.service.model.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class AuthorizationController {

    private final StudentService studentService;
    private final UserRepository userRepository;
    private final UserService userService;
    private final StudentRepository studentRepository;

    public AuthorizationController(StudentService studentService, UserRepository userRepository, UserService userService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.userRepository = userRepository;

        this.userService = userService;
        this.studentRepository = studentRepository;
    }


    @GetMapping("/login")
    public String signForm() {
        return "authorization";
    }

    @ExceptionHandler
    public ModelAndView notFoundExceptionHandler(NotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("not_found");
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;

    }
}