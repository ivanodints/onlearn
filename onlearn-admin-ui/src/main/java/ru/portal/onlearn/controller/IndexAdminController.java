package ru.portal.onlearn.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexAdminController {

    @Secured({"ADMIN"})
    @GetMapping("/admin")
    public String indexAdminPage(Model model){

        model.addAttribute("allDirection", "None");

        return "index-admin";
    }
}
