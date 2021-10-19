package ru.portal.onlearn.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.controller.DTO.StudentDTO;
import ru.portal.onlearn.model.User;
import ru.portal.onlearn.repo.RoleRepository;
import ru.portal.onlearn.repo.StudentRepository;
import ru.portal.onlearn.repo.UserRepository;
import ru.portal.onlearn.service.DirectionService;
import ru.portal.onlearn.service.FacultyService;
import ru.portal.onlearn.service.StudentService;
import ru.portal.onlearn.service.model.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping
public class StudentController {

    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;
    private final StudentService studentService;
    private final UserRepository userRepository;
    private final UserService userService;
    private final DirectionService directionService;
    private final FacultyService facultyService;

    public StudentController(StudentRepository studentRepository, RoleRepository roleRepository, StudentService studentService, UserRepository userRepository, UserService userService, DirectionService directionService, FacultyService facultyService) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
        this.studentService = studentService;
        this.userRepository = userRepository;
        this.userService = userService;
        this.directionService = directionService;
        this.facultyService = facultyService;
    }

    @GetMapping("/registration/newStudent")
    public String adminStudentCreatePage(Model model){

        List<User> userList = userRepository.findAll();
        User lastUser = userList.get(userList.size()-1);


        model.addAttribute("create", true);
        model.addAttribute("activePage", "Students");
        model.addAttribute("user", lastUser);
        model.addAttribute("student", new StudentDTO());
        model.addAttribute("facultyAll",facultyService.findAllFaculty());
        model.addAttribute("allDirection", directionService.findAllDirection());
        return "student_form_create_ui";
    }

    @Secured({"STUDENT"})
    @GetMapping("/student/{login}/edit")
    public String adminEditStudent(Model model, Principal principal, @PathVariable("login") String login){

        User ourUser = new User();

        List<User> userList = userRepository.findAll();

        for(int i = 0; i<userList.size(); i++){
            if (userList.get(i).getLogin().equals(principal.getName())){
                ourUser = userList.get(i);
            }
        }

        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Students");
        model.addAttribute("studentPict", studentRepository.findByUserLogin(login));
        model.addAttribute("student", studentService.findByUserLogin(login));
        model.addAttribute("allDirection", directionService.findAllDirection());
        model.addAttribute("facultyAll",facultyService.findAllFaculty());
        model.addAttribute("principal",principal.getName());
        model.addAttribute("user", ourUser);
        return "student_form_edit_ui";

    }

    @GetMapping("/student/{login}")
    public String user(Model model,@PathVariable("login") String login) {
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Students");
        model.addAttribute("student", studentService.findByUserLogin(login));
        model.addAttribute("login",login);
        model.addAttribute("allDirection", directionService.findAllDirection());
        model.addAttribute("facultyAll",facultyService.findAllFaculty());
        model.addAttribute("studentPict", studentRepository.findByUserLogin(login));
        return "studentUI";
    }

    @PostMapping("/student/studentPost")
    public String adminPostStudent(Model model, RedirectAttributes redirectAttributes,
                                   @Valid @ModelAttribute("student") StudentDTO studentDTO,
                                   BindingResult bindingResult, Principal principal){
        model.addAttribute("activePage", "Students");
        List<User> userList = userRepository.findAll();

        if (bindingResult.hasErrors()){
            model.addAttribute("activePage", "Students");
            model.addAttribute("user", userRepository.findAll());
            return "student_form_ui";
        }
        try {
            studentService.saveStudent(studentDTO);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            return "redirect:/student/" + principal.getName() + "/edit";
        }
        return "redirect:/";
    }

    @PostMapping("/registration/studentPost")
    public String adminPostStudentRegistration(Model model, RedirectAttributes redirectAttributes,
                                   @Valid @ModelAttribute("student") StudentDTO studentDTO,
                                   BindingResult bindingResult){
        model.addAttribute("activePage", "Students");
        List<User> userList = userRepository.findAll();

        if (bindingResult.hasErrors()){
            model.addAttribute("activePage", "Students");
            model.addAttribute("user", userRepository.findAll());
            return "student_form_create_ui";
        }
        try {
            studentService.saveStudent(studentDTO);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (studentDTO.getId() == null){
                return "redirect:/registration/newStudent";
            }
            return "redirect:/registration/studentUI/" + studentDTO.getId() + "/edit";
        }
        return "redirect:/";
    }

}
