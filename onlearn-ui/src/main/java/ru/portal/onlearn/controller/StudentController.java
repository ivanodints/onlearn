package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.controller.DTO.StudentDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.User;
import ru.portal.onlearn.repo.RoleRepository;
import ru.portal.onlearn.repo.StudentRepository;
import ru.portal.onlearn.repo.UserRepository;
import ru.portal.onlearn.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class StudentController {

    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;
    private final StudentService studentService;
    private final UserRepository userRepository;

    public StudentController(StudentRepository studentRepository, RoleRepository roleRepository, StudentService studentService, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
        this.studentService = studentService;
        this.userRepository = userRepository;
    }

    @GetMapping("/registration/newStudent")
    public String adminStudentCreatePage(Model model){

        List<User> userList = userRepository.findAll();
        User lastUser = userList.get(userList.size()-1);

        model.addAttribute("create", true);
        model.addAttribute("activePage", "Students");
        model.addAttribute("user", lastUser);
        model.addAttribute("student", new StudentDTO());
        return "student_form_create";
    }

    //    @Secured({"STUDENT"})
//    @GetMapping("/registration/student/{login}/edit")
//    public String adminEditStudent(Model model, @PathVariable("login") String login){
//
//        model.addAttribute("edit",true);
//        model.addAttribute("activePage", "Students");
////        model.addAttribute("student", studentRepository.findByUserLogin(login));
//        return "student_form_create";
//    }

    @PostMapping("/registration/studentPost")
    public String adminPostStudent(Model model, RedirectAttributes redirectAttributes,
                                   @Valid @ModelAttribute("student") StudentDTO studentDTO,
                                   BindingResult bindingResult){
        model.addAttribute("activePage", "Students");
        List<User> userList = userRepository.findAll();

        if (bindingResult.hasErrors()){
            model.addAttribute("activePage", "Students");
            model.addAttribute("user", userRepository.findAll());
            return "student_form_create";
        }
        try {
            studentService.saveStudent(studentDTO);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (studentDTO.getId() == null){
                return "redirect:/registration/newStudent";
            }
            return "redirect:/registration/student/" + studentDTO.getId() + "/edit";
        }
        return "redirect:/";
    }

}
