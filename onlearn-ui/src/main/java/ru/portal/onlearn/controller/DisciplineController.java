package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.service.DisciplineService;

import java.util.Optional;

@Controller
@RequestMapping
public class DisciplineController {

    private final DisciplineService disciplineService;
    private final DisciplineRepository disciplineRepository;

    public DisciplineController(DisciplineService disciplineService, DisciplineRepository disciplineRepository) {
        this.disciplineService = disciplineService;
        this.disciplineRepository = disciplineRepository;
    }

    @GetMapping("/discipline")
    public String disciplineListPage(
            @RequestParam(value = "disciplineId", required = false) Long disciplineId,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
            @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
            @RequestParam(value = "sort", required = false) Optional<String> sort,
            Model model){

        model.addAttribute("allDisciplines", disciplineService.findAll());

//        return "discipline-bar";
        return "test-disc-page";

    }

    @GetMapping("/discipline/{id}")
    public String disciplinePage(@PathVariable("id") Long id, Model model){
        model.addAttribute("discipline", disciplineService.findById(id).orElseThrow(NotFoundException::new));

        return "discipline-details";
    }
}
