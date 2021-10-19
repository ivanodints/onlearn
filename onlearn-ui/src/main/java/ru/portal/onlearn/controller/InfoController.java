package ru.portal.onlearn.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.portal.onlearn.service.DirectionService;
import ru.portal.onlearn.service.FacultyService;


public class InfoController {

    private final DirectionService directionService;
    private final FacultyService facultyService;

    public InfoController(DirectionService directionService, FacultyService facultyService) {
        this.directionService = directionService;
        this.facultyService = facultyService;
    }

    @GetMapping("/onlearn/about")
    public String aboutPage(Model model) {

        model.addAttribute("allDirection", directionService.findAllDirection());
        model.addAttribute("facultyAll", facultyService.findAllFaculty());

        return "about";
    }
}
