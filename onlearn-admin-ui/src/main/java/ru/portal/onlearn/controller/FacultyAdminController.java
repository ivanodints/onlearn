package ru.portal.onlearn.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.Faculty;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.service.FacultyAdminService;

import javax.validation.Valid;

@Controller
@RequestMapping
public class FacultyAdminController {

    private final FacultyAdminService facultyAdminService;
    private final FacultyRepository facultyRepository;
    private final DirectionRepository directionRepository;

    public FacultyAdminController(FacultyAdminService facultyAdminService,
                                  FacultyRepository facultyRepository,
                                  DirectionRepository directionRepository) {
        this.facultyAdminService = facultyAdminService;
        this.facultyRepository = facultyRepository;
        this.directionRepository = directionRepository;
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/faculty")
    public String adminFacultyPage(Model model){
        model.addAttribute("activePage", "Faculties");
        model.addAttribute("faculties", facultyAdminService.findAllFaculties());
        return "admin-faculty";
    }

    @Secured({"ADMIN"})
    @DeleteMapping("/admin/faculty/{id}/delete")
    public String adminDeleteFaculty(Model model, @PathVariable("id") Long id){
        model.addAttribute("activePage", "Faculties");
        facultyAdminService.deleteFacultyById(id);
        return "redirect:/admin/faculty";
    }

    @Secured({"ADMIN"})
    @GetMapping ("/admin/faculty/create")
    public String adminFacultyCreatePage(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Faculties");
        model.addAttribute("directions", directionRepository.findAll());
        model.addAttribute("faculty", new Faculty());
        return "faculty_form";
    }

    @Secured({"ADMIN"})
    @GetMapping("/admin/faculty/{id}/edit")
    public String adminEditFaculty(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Faculties");
        model.addAttribute("faculty", facultyAdminService.findFacultyById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("directions", directionRepository.findAll());
        return "faculty_form";
    }

    @Secured({"ADMIN"})
    @PostMapping("/admin/facultyPost")
    public String adminPostFaculty(Model model, RedirectAttributes redirectAttributes, @Valid Faculty faculty){
        model.addAttribute("activePage", "Faculties");
        try {
            facultyRepository.save(faculty);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (faculty.getId() == null){
                return "redirect:/admin/faculty/create";
            }
            return "redirect:/admin/faculty/" + faculty.getId() + "/edit";
        }
        return "redirect:/admin/faculty";
    }
}
