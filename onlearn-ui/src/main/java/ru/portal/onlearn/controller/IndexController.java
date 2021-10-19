package ru.portal.onlearn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.service.DirectionService;
import ru.portal.onlearn.service.FacultyService;
import ru.portal.onlearn.service.StudentService;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping
public class IndexController {

    private final DirectionRepository directionRepository;
    private final DirectionService directionService;
    private final FacultyRepository facultyRepository;
    private final FacultyService facultyService;
    private final StudentService studentService;

    public IndexController(DirectionRepository directionRepository, DirectionService directionService, FacultyRepository facultyRepository, FacultyService facultyService, StudentService studentService) {
        this.directionRepository = directionRepository;
        this.directionService = directionService;
        this.facultyRepository = facultyRepository;
        this.facultyService = facultyService;
        this.studentService = studentService;
    }

    @GetMapping()
    public String indexPage(@RequestParam(value = "directionId", required = false) Long directionId,
                            @RequestParam(value = "facultyId", required = false) Long facultyId,
                            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                            @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
                            @RequestParam(value = "sort", required = false) Optional<String> sort,
                            Model model,Principal principal){
        String empty = null;
        model.addAttribute("allDirection", directionService.findAllDirection());
        model.addAttribute("facultyAll",facultyService.findAllFaculty());
      if (principal !=null) {
        model.addAttribute("userOnline",principal.getName());
    } else
    { model.addAttribute("userOnline",empty);}
        return "indexUI";
    }
}






