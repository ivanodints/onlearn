package ru.portal.onlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.portal.onlearn.repo.FacultyRepository;

import java.util.Optional;

@Controller
@RequestMapping
public class FacultyController {

    private static final Logger logger = LoggerFactory.getLogger(FacultyController.class);

    private final FacultyRepository facultyRepository;

    public FacultyController(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @GetMapping("/faculty")
    public String directionsPage(@RequestParam(value = "facultyId", required = false) Long facultyId,
                                         @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                                         @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
                                         @RequestParam(value = "sort", required = false) Optional<String> sort,
                                         Model model){

        logger.info("Faculty list page");

//        System.out.println(facultyRepository.findAll());

        model.addAttribute("allFaculties", facultyRepository.findAll());

        return "test-fac-page";

    }

}
