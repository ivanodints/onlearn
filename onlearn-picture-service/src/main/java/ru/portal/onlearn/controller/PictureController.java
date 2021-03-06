package ru.portal.onlearn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import ru.portal.onlearn.model.*;
import ru.portal.onlearn.repo.PictureRepository;
import ru.portal.onlearn.service.PictureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/picture")
public class PictureController {

    private final PictureService pictureService;
    private final PictureRepository pictureRepository;

    @Autowired
    public PictureController(PictureService pictureService, PictureRepository pictureRepository) {
        this.pictureService = pictureService;
        this.pictureRepository = pictureRepository;
    }

    @GetMapping("/{pictureId}")
    public void downloadProductPicture(@PathVariable("pictureId") Long pictureId, HttpServletResponse resp) throws IOException {

        Optional<String> opt = pictureService.getPictureContentTypeById(pictureId);
        if (opt.isPresent()) {
            resp.setContentType(opt.get());
            resp.getOutputStream().write(pictureService.getPictureDataById(pictureId).get());
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @GetMapping("/deleteDirectionPicture/{pictureId}")
    public String deleteDirectionPicture(@PathVariable("pictureId") Long pictureId) {
        Direction direction = pictureService.getDirectionByPictureId(pictureId).get();

        pictureService.removePicture(pictureId);
        return "redirect:/admin/direction/" + direction.getId() + "/edit";
    }

    @GetMapping("/deleteDisciplinePicture/{pictureId}")
    public String deleteDisciplinePicture(@PathVariable("pictureId") Long pictureId) {
        Discipline discipline = pictureService.getDisciplineByPictureId(pictureId).get();

        pictureService.removePicture(pictureId);
        return "redirect:/admin/discipline/" + discipline.getId() + "/edit";
    }

    @GetMapping("/deleteFacultyPicture/{pictureId}")
    public String deleteFacultyPicture(@PathVariable("pictureId") Long pictureId) {
        Faculty faculty = pictureService.getFacultyByPictureId(pictureId).get();

        pictureService.removePicture(pictureId);
        return "redirect:/admin/faculty/" + faculty.getId() + "/edit";
    }

    @GetMapping("/deleteEmployeePicture/{pictureId}")
    public String deleteEmployeePicture(@PathVariable("pictureId") Long pictureId) {
        Employee employee = pictureService.getEmployeeByPictureId(pictureId).get();

        pictureService.removePicture(pictureId);
        return "redirect:/admin/employee/" + employee.getId() + "/edit";
    }

    @GetMapping("/deleteStudentPicture/{pictureId}")
    public String deleteStudentPicture(@PathVariable("pictureId") Long pictureId) {

        Student student = pictureService.getStudentByPictureId(pictureId).get();

        pictureService.removePicture(pictureId);


        return "redirect:/admin/student/" + student.getId() + "/edit";

    }

    @GetMapping("/ui/deleteStudentPicture/{pictureId}")
    public String deleteStudentPictureUI(@PathVariable("pictureId") Long pictureId, Principal principal) {

        Student student = pictureService.getStudentByPictureId(pictureId).get();

        pictureService.removePicture(pictureId);


        return "redirect:/student/" + principal.getName() + "/edit";

    }
}
