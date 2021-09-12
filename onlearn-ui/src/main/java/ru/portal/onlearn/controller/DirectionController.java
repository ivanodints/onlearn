package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.repo.DirectionRepository;

import java.util.Optional;

@Controller
@RequestMapping
public class DirectionController {

//    private final SphereOfActivitiesService sphereOfActivitiesService;
    private final DirectionRepository directionRepository;
    private final FacultyRepository facultyRepository;

    public DirectionController(DirectionRepository directionRepository, FacultyRepository facultyRepository) {
        this.directionRepository = directionRepository;
        this.facultyRepository = facultyRepository;
    }

//    public SphereOfActivitiesController(SphereOfActivitiesService sphereOfActivitiesService,
//                                        SphereOfActivitiesRepository sphereOfActivitiesRepository,
//                                        FacultyRepository facultyRepository) {
//        this.sphereOfActivitiesService = sphereOfActivitiesService;
//        this.sphereOfActivitiesRepository = sphereOfActivitiesRepository;
//        this.facultyRepository = facultyRepository;
//    }



    @GetMapping("/sphere")
    public String sphereOfActivitiesPage(@RequestParam(value = "sphereId", required = false) Long sphereId,
                                         @RequestParam(value = "facultyId", required = false) Long facultyId,
                                         @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                                         @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
                                         @RequestParam(value = "sort", required = false) Optional<String> sort,
                                         Model model){

        model.addAttribute("allSpheres", directionRepository.findAll());
//        model.addAttribute("allFaculty", facultyRepository.findAll());

        return "test-sphere-page";

    }
}
