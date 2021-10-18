package ru.portal.onlearn.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.controller.DTO.DirectionAdminDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.service.DirectionAdminService;

import javax.validation.Valid;

@Controller
@RequestMapping
public class DirectionAdminController {

    private final DirectionAdminService directionAdminService;
    private final DirectionRepository directionRepository;

    public DirectionAdminController(DirectionAdminService directionAdminService,
                                    DirectionRepository directionRepository) {
        this.directionAdminService = directionAdminService;
        this.directionRepository = directionRepository;
    }

    @Secured({"ADMIN"})
    @GetMapping("/onlearn/admin/direction")
    public String adminDirectionsPage(Model model){
        model.addAttribute("activePage", "Directions");
        model.addAttribute("directions", directionAdminService.findAllDirection());
        return "admin-direction";
    }

    @Secured({"SUPER-ADMIN"})
    @DeleteMapping("/onlearn/admin/direction/{id}/delete")
    public String adminDeleteDirection(Model model, @PathVariable("id") Long id){
        model.addAttribute("activePage", "Directions");
        directionAdminService.deleteDirectionById(id);
        return "redirect:/onlearn/admin/direction";
    }


    @Secured({"ADMIN"})
    @GetMapping ("/onlearn/admin/direction/create")
    public String adminDirectionCreatePage(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Directions");
        model.addAttribute("direction", new DirectionAdminDTO());
        return "direction_form";
    }

    @Secured({"ADMIN"})
    @GetMapping("/onlearn/admin/direction/{id}/edit")
    public String adminEditDirection(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Directions");
        model.addAttribute("direction", directionAdminService.findDirectionById(id).orElseThrow(NotFoundException::new));
        return "direction_form";
    }

    @Secured({"ADMIN"})
    @PostMapping("/onlearn/admin/directionPost")
    public String adminPostDirection(Model model, RedirectAttributes redirectAttributes,
                                     @Valid @ModelAttribute("direction") DirectionAdminDTO directionAdminDTO,
                                     BindingResult bindingResult){
        model.addAttribute("activePage", "Directions");

        if (bindingResult.hasErrors()){
//            model.addAttribute("direction", new DirectionAdminDTO());
            return "direction_form";
        }
        try {
            directionAdminService.saveDirection(directionAdminDTO);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (directionAdminDTO.getId() == null){
                return "redirect:/onlearn/admin/direction/create";
            }
            return "redirect:/onlearn/admin/direction/" + directionAdminDTO.getId() + "/edit";
        }
        return "redirect:/onlearn/admin/direction";
    }
}
