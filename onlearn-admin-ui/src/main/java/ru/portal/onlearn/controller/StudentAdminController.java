package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.model.Student;
import ru.portal.onlearn.repo.RoleRepository;
import ru.portal.onlearn.repo.StudentRepository;
import ru.portal.onlearn.service.StudentAdminService;

@Controller
public class StudentAdminController {

    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;
    private final StudentAdminService studentAdminService;

    public StudentAdminController(StudentRepository studentRepository, RoleRepository roleRepository, StudentAdminService studentAdminService) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
        this.studentAdminService = studentAdminService;
    }

    @GetMapping("/admin/student")
    public String adminStudentPage(Model model){
        model.addAttribute("activePage", "Students");
        model.addAttribute("students", studentAdminService.findAllStudent());
        return "admin-student";
    }

    @DeleteMapping("/admin/student/{id}/delete")
    public String adminDeleteStudent(Model model, @PathVariable("id") Long id){
        model.addAttribute("activePage", "Students");
        studentAdminService.deleteStudentById(id);
        return "redirect:/admin/student";
    }

    @GetMapping ("/admin/student/create")
    public String adminFacultyCreatePage(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Students");
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("student", new Student());
        return "student_form";
    }

    @GetMapping("/admin/student/{id}/edit")
    public String adminEditFaculty(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Students");
        model.addAttribute("employee", studentAdminService.findStudentById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("roles", roleRepository.findAll());
        return "student_form";
    }

    @PostMapping("/admin/studentPost")
    public String adminPostFaculty(Model model, RedirectAttributes redirectAttributes, Student student){
        model.addAttribute("activePage", "Students");
        try {
            studentRepository.save(student);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (student.getId() == null){
                return "redirect:/admin/student/create";
            }
            return "redirect:/admin/student/" + student.getId() + "/edit";
        }
        return "redirect:/admin/student";
    }
}
