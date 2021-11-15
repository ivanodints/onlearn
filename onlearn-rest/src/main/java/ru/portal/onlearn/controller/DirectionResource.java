package ru.portal.onlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.portal.onlearn.controller.DTO.DirectionRestDTO;
import ru.portal.onlearn.exeption.NotFoundException;
import ru.portal.onlearn.service.DirectionRestService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/direction")
public class DirectionResource {

    private final DirectionRestService directionRestService;

    public DirectionResource(DirectionRestService directionRestService) {
        this.directionRestService = directionRestService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<DirectionRestDTO> findAll() {
        return directionRestService.findAllDirection().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public DirectionRestDTO findById(@PathVariable("id") Long id) {
        DirectionRestDTO directionRestDTO = directionRestService.findDirectionById(id)
                .orElseThrow(NotFoundException::new);

        return directionRestDTO;
    }
}
