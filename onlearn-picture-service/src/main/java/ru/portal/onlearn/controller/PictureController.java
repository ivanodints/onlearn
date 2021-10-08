package ru.portal.onlearn.controller;

import ru.portal.onlearn.model.*;
import ru.portal.onlearn.service.PictureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/picture")
public class PictureController {

    private final PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
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

//    @DeleteMapping("delete/{pictureId}")
//    public String deletePicture(@PathVariable("pictureId") Long pictureId) {
//        Direction direction = pictureService.getDirectionByPictureId(pictureId).get();
//        Discipline discipline = pictureService.getDisciplineByPictureId(pictureId).get();
//        Faculty faculty = pictureService.getFacultyByPictureId(pictureId).get();
//        Employee employee = pictureService.getEmployeeByPictureId(pictureId).get();
//        Student student = pictureService.getStudentByPictureId(pictureId).get();
//
//        if (direction != null){
//            pictureService.removePicture(pictureId);
//            return "redirect:/admin/direction/" + direction.getId() + "/edit";
//        } else if (discipline != null){
//            pictureService.removePicture(pictureId);
//            return "redirect:/admin/discipline/" + discipline.getId() + "/edit";
//        } else if (faculty != null){
//            pictureService.removePicture(pictureId);
//            return "redirect:/admin/faculty/" + faculty.getId() + "/edit";
//        } else if (employee != null){
//            pictureService.removePicture(pictureId);
//            return "redirect:/admin/employee/" + employee.getId() + "/edit";
//        } else {
//            pictureService.removePicture(pictureId);
//            return "redirect:/admin/student/" + student.getId() + "/edit";
//        }
//    }

    @DeleteMapping("deleteDirectionPicture/{pictureId}")
    public String deleteDirectionPicture(@PathVariable("pictureId") Long pictureId) {
        Direction direction = pictureService.getDirectionByPictureId(pictureId).get();

        pictureService.removePicture(pictureId);
        return "redirect:/admin/direction/" + direction.getId() + "/edit";
    }

    @DeleteMapping("deleteDisciplinePicture/{pictureId}")
    public String deleteDisciplinePicture(@PathVariable("pictureId") Long pictureId) {
        Discipline discipline = pictureService.getDisciplineByPictureId(pictureId).get();

        pictureService.removePicture(pictureId);
        return "redirect:/admin/direction/" + discipline.getId() + "/edit";
    }

    @DeleteMapping("deleteFacultyPicture/{pictureId}")
    public String deleteFacultyPicture(@PathVariable("pictureId") Long pictureId) {
        Faculty faculty = pictureService.getFacultyByPictureId(pictureId).get();

        pictureService.removePicture(pictureId);
        return "redirect:/admin/direction/" + faculty.getId() + "/edit";
    }

    @DeleteMapping("deleteEmployeePicture/{pictureId}")
    public String deleteEmployeePicture(@PathVariable("pictureId") Long pictureId) {
        Employee employee = pictureService.getEmployeeByPictureId(pictureId).get();

        pictureService.removePicture(pictureId);
        return "redirect:/admin/direction/" + employee.getId() + "/edit";
    }

    @DeleteMapping("deleteStudentPicture/{pictureId}")
    public String deleteStudentPicture(@PathVariable("pictureId") Long pictureId) {
        Student student = pictureService.getStudentByPictureId(pictureId).get();

        pictureService.removePicture(pictureId);
        return "redirect:/admin/direction/" + student.getId() + "/edit";
    }
}
