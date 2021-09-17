package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.service.DisciplineAdminService;

@Controller
public class DisciplineAdminController {

    private final DisciplineAdminService disciplineAdminService;
    private final DisciplineRepository disciplineRepository;

    public DisciplineAdminController(DisciplineAdminService disciplineAdminService,
                                     DisciplineRepository disciplineRepository) {
        this.disciplineAdminService = disciplineAdminService;
        this.disciplineRepository = disciplineRepository;
    }

    @GetMapping("/admin/discipline")
    public String adminDisciplinesPage(Model model){
        model.addAttribute("activePage", "Disciplines");
        model.addAttribute("disciplines", disciplineAdminService.findAllDiscipline());
        return "admin-discipline";
    }

    @DeleteMapping("/admin/discipline/{id}/delete")
    public String adminDeleteDiscipline(Model model, @PathVariable("id") Long id){
        model.addAttribute("activePage", "Disciplines");
        disciplineAdminService.deleteDisciplineById(id);
        return "redirect:/admin/discipline";
    }

    @GetMapping ("/admin/discipline/create")
    public String adminDirectionCreatePage(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Disciplines");
        model.addAttribute("discipline", new Discipline());
        return "discipline_form";
    }

    @GetMapping("/admin/discipline/{id}/edit")
    public String adminEditDirection(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Disciplines");
        model.addAttribute("discipline", disciplineAdminService.findDisciplineById(id).orElseThrow(NotFoundException::new));
        return "discipline_form";
    }

    @PostMapping("/admin/disciplinePost")
    public String adminPostDirection(Model model, RedirectAttributes redirectAttributes, Discipline discipline){
        model.addAttribute("activePage", "Disciplines");
        try {
            disciplineRepository.save(discipline);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (discipline.getId() == null){
                return "redirect:/admin/discipline/create";
            }
            return "redirect:/admin/discipline/" + discipline.getId() + "/edit";
        }
        return "redirect:/admin/discipline";
    }

}
