package ru.portal.onlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.portal.onlearn.repo.DisciplineRepository;
import ru.portal.onlearn.repo.EmployeeRepository;

import java.util.Optional;

@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employee")
    public String employeePage(@RequestParam(value = "employeeId", required = false) Long facultyId,
                               @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                               @RequestParam(value = "tableSize", required = false, defaultValue = "6") Integer tableSize,
                               @RequestParam(value = "sort", required = false) Optional<String> sort,
                               Model model) {

        model.addAttribute("allEmployee", employeeRepository.findAll());

        return "test-employee-page";
    }
}
