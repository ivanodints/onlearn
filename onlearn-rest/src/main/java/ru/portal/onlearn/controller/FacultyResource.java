package ru.portal.onlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.portal.onlearn.controller.DTO.DirectionRestDTO;
import ru.portal.onlearn.controller.DTO.FacultyRestDTO;
import ru.portal.onlearn.exeption.NotFoundException;
import ru.portal.onlearn.service.FacultyRestService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/faculty")
public class FacultyResource {

    private final FacultyRestService facultyRestService;

    public FacultyResource(FacultyRestService facultyRestService) {
        this.facultyRestService = facultyRestService;
    }


    @GetMapping(path = "/all", produces = "application/json")
    public List<FacultyRestDTO> findAll() {
        List<FacultyRestDTO>  facultyRestDTO = facultyRestService.findAllFaculty().stream().collect(Collectors.toList());
        return facultyRestDTO;

    }

    @GetMapping(path = "/{id}")
    public FacultyRestDTO findById(@PathVariable("id") Long id) {
        FacultyRestDTO facultyRestDTO = facultyRestService.findFacultyById(id)
                .orElseThrow(NotFoundException::new);
        return facultyRestDTO;
    }
}
