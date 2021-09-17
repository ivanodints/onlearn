package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.portal.onlearn.repo.FacultyRepository;
import ru.portal.onlearn.repo.DirectionRepository;
import ru.portal.onlearn.service.DirectionService;

import java.util.Optional;

@Controller
@RequestMapping
public class DirectionController {

    private final DirectionService directionService;

    public DirectionController(DirectionService directionService) {
        this.directionService = directionService;

    }


    @GetMapping("/direction")
    public String directionPage(@RequestParam(value = "directionId", required = false) Long directionId,
                                @RequestParam(value = "facultyId", required = false) Long facultyId,
                                @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                                @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
                                @RequestParam(value = "sort", required = false) Optional<String> sort,
                                Model model){

        model.addAttribute("allDirection", directionService.findAllDirection());

        return "direction";
    }

    //С таким маппингом CSS офорлмение работает, но маппинг не корректен
//    @GetMapping("/{id}")
    //Данный маппинг корректен, но он почему то оформление CSS ломает
    @GetMapping("/{id}/direction")
    public String directionIdPage(@PathVariable Long id, Model model) throws Exception {

        model.addAttribute("directionAll", directionService.findAllDirection());
        model.addAttribute("directionId", directionService.findDirectionById(id).orElseThrow(Exception::new));

        return "directionID";
    }


}
