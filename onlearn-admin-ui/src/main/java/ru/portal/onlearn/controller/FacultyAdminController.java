package ru.portal.onlearn.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.portal.onlearn.controller.DTO.FacultyAdminDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.service.FacultyAdminService;


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
    @GetMapping("/onlearn/admin/faculty")
    public String adminFacultyPage(Model model){
        model.addAttribute("activePage", "Faculties");
        model.addAttribute("faculties", facultyAdminService.findAllFaculties());
        return "admin-faculty";
    }

    @Secured({"SUPER-ADMIN"})
    @DeleteMapping("/onlearn/admin/faculty/{id}/delete")
    public String adminDeleteFaculty(Model model, @PathVariable("id") Long id){
        model.addAttribute("activePage", "Faculties");
        facultyAdminService.deleteFacultyById(id);
        return "redirect:/onlearn/admin/faculty";
    }

    @Secured({"ADMIN"})
    @GetMapping ("/onlearn/admin/faculty/create")
    public String adminFacultyCreatePage(Model model){
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Faculties");
        model.addAttribute("directions", directionRepository.findAll());
        model.addAttribute("faculty", new FacultyAdminDTO());
        return "faculty_form";
    }

    @Secured({"ADMIN"})
    @GetMapping("/onlearn/admin/faculty/{id}/edit")
    public String adminEditFaculty(Model model, @PathVariable("id") Long id){
        model.addAttribute("edit",true);
        model.addAttribute("activePage", "Faculties");
        model.addAttribute("faculty", facultyAdminService.findFacultyById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("directions", directionRepository.findAll());
        return "faculty_form";
    }

    @Secured({"ADMIN"})
    @PostMapping("/onlearn/admin/facultyPost")
    public String adminPostFaculty(Model model, RedirectAttributes redirectAttributes, FacultyAdminDTO facultyAdminDTO){
        model.addAttribute("activePage", "Faculties");
        try {
            facultyAdminService.saveFaculty(facultyAdminDTO);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (facultyAdminDTO.getId() == null){
                return "redirect:/onlearn/admin/faculty/create";
            }
            return "redirect:/onlearn/admin/faculty/" + facultyAdminDTO.getId() + "/edit";
        }
        return "redirect:/onlearn/admin/faculty";
    }
}
