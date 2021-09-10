package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.repo.SphereOfActivitiesRepository;

import java.util.Optional;

@Controller
@RequestMapping
public class SphereOfActivitiesController {


    private final SphereOfActivitiesRepository sphereOfActivitiesRepository;
    private final FacultyRepository facultyRepository;

    public SphereOfActivitiesController(SphereOfActivitiesRepository sphereOfActivitiesRepository, FacultyRepository facultyRepository) {
        this.sphereOfActivitiesRepository = sphereOfActivitiesRepository;
        this.facultyRepository = facultyRepository;
    }


    @GetMapping("/chair")
    public String sphereOfActivitiesPage(@RequestParam(value = "sphereId", required = false) Long sphereId,
                                         @RequestParam(value = "facultyId", required = false) Long facultyId,
                                         @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                                         @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
                                         @RequestParam(value = "sort", required = false) Optional<String> sort,
                                         Model model){


        // sphereOfActivitiesRepository.findAll() нужно заменять на обращение "название сервиса".findAll().
        model.addAttribute("allSpheres", sphereOfActivitiesRepository.findAll());
//        model.addAttribute("allFaculty", facultyRepository.findAll());

//        return "test-sphere-page";
        return "chair";

    }
}
