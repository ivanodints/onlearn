package ru.portal.onlearn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class IndexController {

    public String indexPage(Model model, HttpSession httpSession) {
        return "index";
    }
}
