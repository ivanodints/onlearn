package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.portal.onlearn.service.DirectionService;
import ru.portal.onlearn.service.FacultyService;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping
public class InfoController {

    private final DirectionService directionService;
    private final FacultyService facultyService;

    public InfoController(DirectionService directionService, FacultyService facultyService) {
        this.directionService = directionService;
        this.facultyService = facultyService;
    }

    @GetMapping("/about")
    public String aboutPage(@RequestParam(value = "directionId", required = false) Long directionId,
                            @RequestParam(value = "facultyId", required = false) Long facultyId,
                            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                            @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
                            @RequestParam(value = "sort", required = false) Optional<String> sort,
                            Model model, Principal principal) {

        String empty = null;
        model.addAttribute("allDirection", directionService.findAllDirection());
        model.addAttribute("facultyAll",facultyService.findAllFaculty());
        if (principal !=null) {
            model.addAttribute("userOnline",principal.getName());
        } else
        { model.addAttribute("userOnline",empty);}
        return "about";
    }

    @GetMapping("/contact")
    public String ContactPage(@RequestParam(value = "directionId", required = false) Long directionId,
                            @RequestParam(value = "facultyId", required = false) Long facultyId,
                            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                            @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
                            @RequestParam(value = "sort", required = false) Optional<String> sort,
                            Model model, Principal principal) {

        String empty = null;
        model.addAttribute("allDirection", directionService.findAllDirection());
        model.addAttribute("facultyAll",facultyService.findAllFaculty());
        if (principal !=null) {
            model.addAttribute("userOnline",principal.getName());
        } else
        { model.addAttribute("userOnline",empty);}
        return "contact";
    }

}
