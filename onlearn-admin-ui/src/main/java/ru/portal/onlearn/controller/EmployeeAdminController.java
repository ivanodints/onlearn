package ru.portal.onlearn.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Employee;
import ru.portal.onlearn.repo.DepartmentRepository;
import ru.portal.onlearn.repo.EmployeeRepository;
import ru.portal.onlearn.repo.RoleRepository;
import ru.portal.onlearn.service.EmployeeAdminService;

@Controller
public class EmployeeAdminController {

    private final EmployeeAdminService employeeAdminService;
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final RoleRepository roleRepository;

    public EmployeeAdminController(EmployeeAdminService employeeAdminService,
                                   EmployeeRepository employeeRepository,
                                   DepartmentRepository departmentRepository, RoleRepository roleRepository) {
        this.employeeAdminService = employeeAdminService;
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/employee")
    public String adminFacultyPage(Model model){
        model.addAttribute("activePage", "Employees");
        model.addAttribute("employees", employeeAdminService.findAllEmployee());
        return "admin-employee";
    }

    @Secured({"ADMIN"})
    @DeleteMapping("/admin/employee/{id}/delete")
    public String adminDeleteFaculty(Model model, @PathVariable("id") Long id){
        model.addAttribute("activePage", "Employees");
        employeeAdminService.deleteEmployeeById(id);
        return "redirect:/admin/faculty";
    }

    @Secured({"ADMIN"})
    @GetMapping ("/admin/employee/create")
    public String adminFacultyCreatePage(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Employees");
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("employee", new Employee());
        return "employee_form";
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/employee/{id}/edit")
    public String adminEditFaculty(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Employees");
        model.addAttribute("employee", employeeAdminService.findEmployeeById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        return "employee_form";
    }

    @Secured({"ADMIN"})
    @PostMapping("/admin/employeePost")
    public String adminPostFaculty(Model model, RedirectAttributes redirectAttributes, Employee employee){
        model.addAttribute("activePage", "Employees");
        try {
            employeeRepository.save(employee);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (employee.getId() == null){
                return "redirect:/admin/employee/create";
            }
            return "redirect:/admin/employee/" + employee.getId() + "/edit";
        }
        return "redirect:/admin/employee";
    }
}
