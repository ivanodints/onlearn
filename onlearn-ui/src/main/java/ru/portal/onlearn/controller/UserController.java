package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.controller.DTO.UserDTO;
import ru.portal.onlearn.repo.RoleRepository;
import ru.portal.onlearn.repo.UserRepository;
import ru.portal.onlearn.service.model.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final RoleRepository roleRepository;

    public UserController(UserRepository userRepository, UserService userService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }


    @GetMapping ("/registration")
    public String adminUserCreatePage(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("roles", roleRepository.findByTitle("ROLE_STUDENT"));
        model.addAttribute("user", new UserDTO());

        return "user_form_create";
    }


    @PostMapping("/registration/userPost")
    public String adminPostUser(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("user") UserDTO userDTO,
                                BindingResult bindingResult){
        model.addAttribute("activePage", "Users");

        if (bindingResult.hasErrors() ){
            model.addAttribute("roles", roleRepository.findByTitle("ROLE_STUDENT"));
            return "user_form_create";
        }
        try {
            userService.saveUser(userDTO);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (userDTO.getId() == null){
                return "redirect:/registration";
            }
            return "redirect:/registration";
        }
        return "redirect:/registration/newStudent";
    }


}
