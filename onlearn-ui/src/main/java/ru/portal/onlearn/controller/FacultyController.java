package ru.portal.onlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.service.DirectionService;
import ru.portal.onlearn.service.DisciplineService;
import ru.portal.onlearn.service.FacultyService;
import ru.portal.onlearn.service.PictureService;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping
public class FacultyController {

    private static final Logger logger = LoggerFactory.getLogger(FacultyController.class);

    private final FacultyRepository facultyRepository;
    private final FacultyService facultyService;
    private final DisciplineService disciplineService;
    private final PictureService pictureService;
    private final DirectionService directionService;
    private final DisciplineRepository disciplineRepository;

    public FacultyController(FacultyRepository facultyRepository, FacultyService facultyService,
                             DisciplineService disciplineService, PictureService pictureService, DirectionService directionService, DisciplineRepository disciplineRepository) {
        this.facultyRepository = facultyRepository;
        this.facultyService = facultyService;
        this.disciplineService = disciplineService;
        this.pictureService = pictureService;
        this.directionService = directionService;
        this.disciplineRepository = disciplineRepository;
    }

    @GetMapping("/faculty")
    public String facultyPage(@RequestParam(value = "facultyId", required = false) Long facultyId,
                              @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                              @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
                              @RequestParam(value = "sort", required = false) Optional<String> sort,
                              Model model, Principal principal){

        logger.info("Faculty list page");
        String empty = null;
        model.addAttribute("allFaculties", facultyService.findAllFaculty());

        if (principal !=null) {
            model.addAttribute("userOnline",principal.getName());
        } else
        { model.addAttribute("userOnline",empty);}
        return "facultyUI";
    }

    @GetMapping("/faculty/{id}")
    public String facultyIdPage (@PathVariable Long id, Model model, Principal principal) throws Exception {

        String empty = null;
        model.addAttribute("pictures", pictureService.findAllPictures());
        model.addAttribute("facultyAll",facultyService.findAllFaculty());
        model.addAttribute("facultyId",facultyService.findFacultyById(id).orElseThrow(Exception::new));

        if (principal !=null) {
            model.addAttribute("userOnline",principal.getName());
        } else
        { model.addAttribute("userOnline",empty);}
        return "facultyIDUI";
    }

    @GetMapping("/faculty/{id}/listDisciplineFacultyUI")
    public String listDisciplineFacultyPage(@PathVariable("id") Long id, Model model, Principal principal) throws Exception {

        String empty = null;

        model.addAttribute("allDirection", directionService.findAllDirection());
        model.addAttribute("findAll", facultyService.findAllFaculty());
        model.addAttribute("allDiscipline", disciplineService.findAllDiscipline());
        model.addAttribute("facultyId",facultyService.findFacultyById(id).orElseThrow(Exception::new));
        model.addAttribute("listDiscipline", disciplineService.findDisciplineByFaculty(id));

        if (principal !=null) {
            model.addAttribute("userOnline",principal.getName());
        } else {
            model.addAttribute("userOnline",empty);
        }
        
        return "listDisciplineFacultyUI";
    }

}
