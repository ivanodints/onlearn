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
import java.util.List;

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

    @Secured({"STUDENT"})
    @GetMapping("/student/{login}/edit")
    public String adminEditStudent(Model model, @PathVariable("login") String login){

        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Students");
        model.addAttribute("student", studentRepository.findByUserLogin(login));
        return "student_form";
    }
@GetMapping("/student/{login}")
public String user(Model model,@PathVariable("login") String login) {
//    UserDetails user = (UserDetails) authentication.getPrincipal();
//    UserDetails userDetails = (UserDetails) org.springframework.security.core.context.SecurityContextHolder
//            .getContext().getAuthentication().getPrincipal();
//    String userName = userDetails.getUsername();
//    id =userDetails.;
//     id = userRepository.findUserByLogin(userName).map(user -> userService.findUserByLogin(userName));
//    System.out.println("id: "+id);
    //.findUserByLogin(userName).get().getId();

    model.addAttribute("edit",true);
        model.addAttribute("activePage", "Students");
        model.addAttribute("student", studentRepository.findByUserLogin(login));
//    System.out.println((UserDetails)authentication.getPrincipal());
    return "student";
}

    @PostMapping("/student/studentPost")
    public String adminPostStudent(Model model, RedirectAttributes redirectAttributes,
                                   @Valid @ModelAttribute("student") StudentDTO studentDTO,
                                   BindingResult bindingResult){
        model.addAttribute("activePage", "Students");
        List<User> userList = userRepository.findAll();

        if (bindingResult.hasErrors()){
            model.addAttribute("activePage", "Students");
            model.addAttribute("user", userRepository.findAll());
            return "student_form";
        }
        try {
            studentService.saveStudent(studentDTO);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
//            if (studentDTO.getId() == null){
//                return "redirect:/registration/newStudent";
//            }
            return "redirect:/student/student/" + studentDTO.getId() + "/edit";
        }
        return "redirect:/";
    }

    @ExceptionHandler
    public ModelAndView notFoundExceptionHandler(NotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("not_found");
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;

    }
}