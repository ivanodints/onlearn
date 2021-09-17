package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.service.DirectionService;
import ru.portal.onlearn.service.DisciplineService;

import java.util.Optional;

@Controller
@RequestMapping
public class DisciplineController {

    private final DisciplineService disciplineService;

    private final DirectionService directionService;

    private final DirectionRepository directionRepository;

    public DisciplineController(DisciplineService disciplineService,
                                DirectionService directionService, DirectionRepository directionRepository) {
        this.disciplineService = disciplineService;
        this.directionService = directionService;
        this.directionRepository = directionRepository;
    }

    @GetMapping("/discipline")
    public String disciplineListPage(
            @RequestParam(value = "disciplineId", required = false) Long disciplineId,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
            @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
            @RequestParam(value = "sort", required = false) Optional<String> sort,
            Model model){

        model.addAttribute("allDiscipline", disciplineService.findAllDiscipline());

        return "discipline";

    }


    @GetMapping("/discipline/{id}")
    public String disciplinePage(@PathVariable("id") Long id, Model model) {

        model.addAttribute("allDirection", directionService.findAllDirection());
        model.addAttribute("disciplineAll",disciplineService.findAllDiscipline());
        model.addAttribute("disciplineId", disciplineService.findDisciplineById(id).orElseThrow(NotFoundException::new));

        return "disciplineId";
    }
}
