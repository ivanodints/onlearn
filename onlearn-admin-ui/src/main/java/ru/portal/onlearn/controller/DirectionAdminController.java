package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Direction;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.service.DirectionAdminService;

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

    @GetMapping("/admin/direction")
    public String adminDirectionsPage(Model model){
        model.addAttribute("activePage", "Directions");
        model.addAttribute("directions", directionAdminService.findAllDirection());
        return "admin-direction";
    }

    @DeleteMapping("/admin/direction/{id}/delete")
    public String adminDeleteDirection(Model model, @PathVariable("id") Long id){
        model.addAttribute("activePage", "Directions");
        directionAdminService.deleteDirectionById(id);
        return "redirect:/admin/direction";
    }

    @GetMapping ("/admin/direction/create")
    public String adminDirectionCreatePage(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Directions");
        model.addAttribute("direction", new Direction());
        return "direction_form";
    }

    @GetMapping("/admin/direction/{id}/edit")
    public String adminEditDirection(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Directions");
        model.addAttribute("direction", directionAdminService.findDirectionById(id).orElseThrow(NotFoundException::new));
        return "direction_form";
    }

    @PostMapping("/admin/directionPost")
    public String adminPostDirection(Model model, RedirectAttributes redirectAttributes, Direction direction){
        model.addAttribute("activePage", "Directions");
        try {
            directionRepository.save(direction);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (direction.getId() == null){
                return "redirect:/admin/direction/create";
            }
            return "redirect:/admin/direction/" + direction.getId() + "/edit";
        }
        return "redirect:/admin/direction";
    }
}
