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
import ru.portal.onlearn.model.User;
import ru.portal.onlearn.repo.RoleRepository;
import ru.portal.onlearn.repo.UserRepository;
import ru.portal.onlearn.service.UserAdminService;

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
    public String adminFacultyPage(Model model){
        model.addAttribute("activePage", "Users");
        model.addAttribute("users", userAdminService.findAllUser());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin-user";
    }

    @Secured({"ADMIN"})
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
        model.addAttribute("user", new User());
        return "user_form_create";
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/user/{id}/edit")
    public String adminEditFaculty(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", userAdminService.findUserById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("roles", roleRepository.findAll());
        return "user_form";
    }

    @Secured({"ADMIN"})
    @PostMapping("/admin/userPost")
    public String adminPostUser(Model model, RedirectAttributes redirectAttributes, User user){
        model.addAttribute("activePage", "Users");
        try {
            userRepository.save(user);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (user.getId() == null){
                return "redirect:/admin/user/create";
            }
            return "redirect:/admin/user/" + user.getId() + "/edit";
        }
        return "redirect:/admin/employee/create";
    }
}
