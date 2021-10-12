package ru.portal.onlearn.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Department;
import ru.portal.onlearn.repo.DepartmentRepository;
import ru.portal.onlearn.service.DepartmentAdminService;

import javax.validation.Valid;

@Controller
@RequestMapping
public class DepartmentAdminController {

    private final DepartmentAdminService departmentAdminService;

    private final DepartmentRepository departmentRepository;

    public DepartmentAdminController(DepartmentAdminService departmentAdminService, DepartmentRepository departmentRepository) {
        this.departmentAdminService = departmentAdminService;
        this.departmentRepository = departmentRepository;
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/department")
    public String adminDepartmentsPage(Model model){
        model.addAttribute("activePage", "Departments");
        model.addAttribute("departments", departmentAdminService.findAllDepartment());
        return "admin-department";
    }

    @Secured({"ADMIN"})
    @DeleteMapping("/admin/department/{id}/delete")
    public String adminDeleteDepartment(Model model, @PathVariable("id") Long id){
        model.addAttribute("activePage", "Departments");
        departmentAdminService.deleteDepartmentById(id);
        return "redirect:/admin/department";
    }

    @Secured({"ADMIN"})
    @GetMapping ("/admin/department/create")
    public String adminDepartmentCreatePage(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Departments");
        model.addAttribute("department", new Department());
        return "department_form";
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/department/{id}/edit")
    public String adminEditDepartment(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Departments");
        model.addAttribute("department", departmentAdminService.findDepartmentById(id).orElseThrow(NotFoundException::new));
        return "department_form";
    }

    @Secured({"ADMIN"})
    @PostMapping("/admin/departmentPost")
    public String adminPostDepartment(Model model, RedirectAttributes redirectAttributes, @Valid Department department){
        model.addAttribute("activePage", "Departments");
        try {
            departmentRepository.save(department);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (department.getId() == null){
                return "redirect:/admin/department/create";
            }
            return "redirect:/admin/department/" + department.getId() + "/edit";
        }
        return "redirect:/admin/department";
    }
}
