package ru.portal.onlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.service.DisciplineService;
import ru.portal.onlearn.service.FacultyService;
import ru.portal.onlearn.service.PictureService;

import java.util.Optional;

@Controller
@RequestMapping
public class FacultyController {

    private static final Logger logger = LoggerFactory.getLogger(FacultyController.class);

    private final FacultyRepository facultyRepository;
    private final FacultyService facultyService;
    private final DisciplineService disciplineService;
    private final PictureService pictureService;

    public FacultyController(FacultyRepository facultyRepository, FacultyService facultyService,
                             DisciplineService disciplineService, PictureService pictureService) {
        this.facultyRepository = facultyRepository;
        this.facultyService = facultyService;
        this.disciplineService = disciplineService;
        this.pictureService = pictureService;
    }

    @GetMapping("/faculty")
    public String facultyPage(@RequestParam(value = "facultyId", required = false) Long facultyId,
                                         @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                                         @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
                                         @RequestParam(value = "sort", required = false) Optional<String> sort,
                                         Model model){

        logger.info("Faculty list page");

        model.addAttribute("allFaculties", facultyService.findAllFaculty());

        return "facultyUI";
    }

    @GetMapping("/faculty/{id}")
    public String facultyIdPage (@PathVariable Long id, Model model) throws Exception {
        model.addAttribute("pictures", pictureService.findAllPictures());
        model.addAttribute("facultyAll",facultyService.findAllFaculty());
        model.addAttribute("facultyId",facultyService.findFacultyById(id).orElseThrow(Exception::new));
        return "facultyIDUI";
    }

}
