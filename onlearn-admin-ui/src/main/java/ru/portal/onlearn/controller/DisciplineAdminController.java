package ru.portal.onlearn.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.controller.DTO.DisciplineAdminDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Discipline;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.service.DisciplineAdminService;
import ru.portal.onlearn.service.FacultyAdminService;

@Controller
public class DisciplineAdminController {

    private final DisciplineAdminService disciplineAdminService;
    private final DisciplineRepository disciplineRepository;
    private final FacultyRepository facultyRepository;
    private final FacultyAdminService facultyAdminService;

    public DisciplineAdminController(DisciplineAdminService disciplineAdminService,
                                     DisciplineRepository disciplineRepository, FacultyRepository facultyRepository, FacultyAdminService facultyAdminService) {
        this.disciplineAdminService = disciplineAdminService;
        this.disciplineRepository = disciplineRepository;
        this.facultyRepository = facultyRepository;
        this.facultyAdminService = facultyAdminService;
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/discipline")
    public String adminDisciplinesPage(Model model){
        model.addAttribute("activePage", "Disciplines");
        model.addAttribute("disciplines", disciplineAdminService.findAllDiscipline());
        model.addAttribute("faculties", facultyRepository.findAll());
        return "admin-discipline";
    }

    @Secured({"ADMIN"})
    @DeleteMapping("/admin/discipline/{id}/delete")
    public String adminDeleteDiscipline(Model model, @PathVariable("id") Long id){
        model.addAttribute("activePage", "Disciplines");
        disciplineAdminService.deleteDisciplineById(id);
        return "redirect:/admin/discipline";
    }

    @Secured({"ADMIN"})
    @GetMapping ("/admin/discipline/create")
    public String adminDirectionCreatePage(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Disciplines");
        model.addAttribute("faculties", facultyRepository.findAll());
        model.addAttribute("discipline", new DisciplineAdminDTO());
        return "discipline_form";
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/discipline/{id}/edit")
    public String adminEditDirection(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Disciplines");
        model.addAttribute("discipline", disciplineAdminService.findDisciplineById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("faculties", facultyRepository.findAll());
        return "discipline_form";
    }

    @Secured({"ADMIN"})
    @PostMapping("/admin/disciplinePost")
    public String adminPostDirection(Model model, RedirectAttributes redirectAttributes, DisciplineAdminDTO disciplineAdminDTO){
        model.addAttribute("activePage", "Disciplines");
        try {
            disciplineAdminService.saveDiscipline(disciplineAdminDTO);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (disciplineAdminDTO.getId() == null){
                return "redirect:/admin/discipline/create";
            }
            return "redirect:/admin/discipline/" + disciplineAdminDTO.getId() + "/edit";
        }
        return "redirect:/admin/discipline";
    }

}
