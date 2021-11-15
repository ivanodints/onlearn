package ru.portal.onlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.portal.onlearn.controller.DTO.DirectionRestDTO;
import ru.portal.onlearn.controller.DTO.DisciplineRestDTO;
import ru.portal.onlearn.exeption.NotFoundException;
import ru.portal.onlearn.service.DirectionRestService;
import ru.portal.onlearn.service.DisciplineRestService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/discipline")
public class DisciplineResource {

    private final DisciplineRestService disciplineRestService;

    public DisciplineResource(DisciplineRestService disciplineRestService) {
        this.disciplineRestService = disciplineRestService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<DisciplineRestDTO> findAll() {
        return disciplineRestService.findAllDiscipline().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public DisciplineRestDTO findById(@PathVariable("id") Long id) {
        DisciplineRestDTO disciplineRestDTO = disciplineRestService.findDisciplineById(id)
                .orElseThrow(NotFoundException::new);
        return disciplineRestDTO;
    }

}
