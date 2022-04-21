package com.example.icecold.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitorController {

    @GetMapping("/")
    public String showHomepage() {
        return "home";
    }


    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }

}