package ru.portal.onlearn.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.controller.DTO.EmployeeAdminDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.User;
import ru.portal.onlearn.repo.DepartmentRepository;
import ru.portal.onlearn.repo.EmployeeRepository;
import ru.portal.onlearn.repo.RoleRepository;
import ru.portal.onlearn.repo.UserRepository;
import ru.portal.onlearn.service.EmployeeAdminService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeAdminController{

    private final EmployeeAdminService employeeAdminService;
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public EmployeeAdminController(EmployeeAdminService employeeAdminService,
                                   EmployeeRepository employeeRepository,
                                   DepartmentRepository departmentRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.employeeAdminService = employeeAdminService;
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/employee")
    public String adminEmployeePage(Model model){
        model.addAttribute("activePage", "Employees");
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("employees", employeeAdminService.findAllEmployee());
        return "admin-employee";
    }

    @Secured({"SUPER-ADMIN"})
    @DeleteMapping("/admin/employee/{id}/delete")
    public String adminDeleteEmployee(Model model, @PathVariable("id") Long id){
        model.addAttribute("activePage", "Employees");
        employeeAdminService.deleteEmployeeById(id);
        return "redirect:/admin/employee";
    }

    @Secured({"ADMIN"})
    @GetMapping ("/admin/employee/create")
    public String adminEmployeeCreatePage(Model model){

        List <User> userList = userRepository.findAll();
        User lastUser = userList.get(userList.size()-1);

        model.addAttribute("create", true);
        model.addAttribute("activePage", "Employees");
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("user", lastUser);
        model.addAttribute("employee", new EmployeeAdminDTO());
        return "employee_form";
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/employee/{id}/edit")
    public String adminEditEmployee(Model model, @PathVariable("id") Long id){

        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Employees");
        model.addAttribute("employee", employeeAdminService.findEmployeeById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("user", userRepository.findAll());
        return "employee_form";
    }

    @Secured({"ADMIN"})
    @PostMapping("/admin/employeePost")
    public String adminPostEmployee(@Valid @ModelAttribute("employee") EmployeeAdminDTO employeeAdminDTO, BindingResult bindingResult, Model model,
                                    RedirectAttributes redirectAttributes){
        model.addAttribute("activePage", "Employees");

        if (bindingResult.hasErrors()){
            model.addAttribute("departments", departmentRepository.findAll());
            model.addAttribute("user", userRepository.findAll());
            return "employee_form";
        }
        try {
            employeeAdminService.saveEmployee(employeeAdminDTO);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (employeeAdminDTO.getId() == null){
                return "redirect:/admin/employee/create";
            }
            return "redirect:/admin/employee/" + employeeAdminDTO.getId() + "/edit";
        }
        return "redirect:/admin/employee";
    }

}
