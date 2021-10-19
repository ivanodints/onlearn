package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.service.DirectionService;
import ru.portal.onlearn.service.FacultyServiceImpl;
import ru.portal.onlearn.service.PictureService;

import java.util.Optional;

@Controller
@RequestMapping
public class DirectionController {

    private final DirectionService directionService;
    private final FacultyServiceImpl facultyService;
    private final PictureService pictureService;


    public DirectionController(DirectionService directionService, FacultyRepository facultyRepository, FacultyServiceImpl facultyService, PictureService pictureService) {
        this.directionService = directionService;
        this.facultyService = facultyService;
        this.pictureService = pictureService;
    }

    @GetMapping("/direction")
    public String directionPage(@RequestParam(value = "directionId", required = false) Long directionId,
                                @RequestParam(value = "facultyId", required = false) Long facultyId,
                                @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                                @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
                                @RequestParam(value = "sort", required = false) Optional<String> sort,
                                Model model){

        model.addAttribute("allDirection", directionService.findAllDirection());

        return "directionUI";
    }

    @GetMapping("/{id}/direction")
    public String directionIdPage(@PathVariable Long id, Model model) throws Exception {

        model.addAttribute("pictures", pictureService.findAllPictures());
        model.addAttribute("directionAll", directionService.findAllDirection());
        model.addAttribute("directionId", directionService.findDirectionById(id).orElseThrow(Exception::new));
        model.addAttribute("facultyList",facultyService.findByDirectionId(id));

        return "directionIDUI";
    }


}
