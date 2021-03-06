package ru.portal.onlearn.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.controller.DTO.UserAdminDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.User;
import ru.portal.onlearn.repo.RoleRepository;
import ru.portal.onlearn.repo.UserRepository;
import ru.portal.onlearn.service.UserAdminService;

import javax.validation.Valid;

@Controller
public class UserAdminController {

    private final UserRepository userRepository;
    private final UserAdminService userAdminService;
    private final RoleRepository roleRepository;

    public UserAdminController(UserRepository userRepository,
                               UserAdminService userAdminService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userAdminService = userAdminService;
        this.roleRepository = roleRepository;
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/user")
    public String adminUserPage(Model model){
        model.addAttribute("activePage", "Users");
        model.addAttribute("users", userAdminService.findAllUser());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin-user";
    }

    @Secured({"SUPER-ADMIN"})
    @DeleteMapping("/admin/user/{id}/delete")
    public String adminDeleteUser(Model model, @PathVariable("id") Long id){
        model.addAttribute("activePage", "Users");
        userAdminService.deleteUserById(id);
        return "redirect:/admin/user";
    }


    @Secured({"ADMIN"})
    @GetMapping ("/admin/user/create")
    public String adminUserCreatePage(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("user", new UserAdminDTO());
        model.addAttribute("allUsers", userRepository.findAll());

        return "user_form_create";
    }

    @Secured({"ADMIN"})
    @GetMapping ("/admin/userStudent/create")
    public String adminStudentUserCreatePage(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("user", new UserAdminDTO());
        return "student_user_form_create";
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/user/{id}/edit")
    public String adminEditUser(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", userAdminService.findUserById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("roles", roleRepository.findAll());
        return "user_form";
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/userStudent/{id}/edit")
    public String adminEditUserStudent(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", userAdminService.findUserById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("roles", roleRepository.findAll());
        return "student_user_form";
    }

    @Secured({"ADMIN"})
    @PostMapping("/admin/userPost")
    public String adminPostUser(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("user") UserAdminDTO userAdminDTO,
                                BindingResult bindingResult){
        model.addAttribute("activePage", "Users");

        if (bindingResult.hasErrors() ){
            model.addAttribute("roles", roleRepository.findAll());
            return "user_form_create";
        }
        try {
            userAdminService.saveUser(userAdminDTO);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (userAdminDTO.getId() == null){
                return "redirect:/admin/user/create";
            }
            return "redirect:/admin/user/" + userAdminDTO.getId() + "/edit";
        }
        return "redirect:/admin/employee/create";
    }

    @Secured({"ADMIN"})
    @PostMapping("/admin/userStudentPost")
    public String adminPostStudentUser(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("user") UserAdminDTO userAdminDTO,
                                BindingResult bindingResult){
        model.addAttribute("activePage", "Users");

        if (bindingResult.hasErrors()){
            model.addAttribute("roles", roleRepository.findAll());
            return "student_user_form_create";
        }
        try {
            userAdminService.saveUser(userAdminDTO);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (userAdminDTO.getId() == null){
                return "redirect:/admin/userStudent/create";
            }
            return "redirect:/admin/userStudent/" + userAdminDTO.getId() + "/edit";
        }
        return "redirect:/admin/student/create";
    }

}
