package com.property.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/accessDenied")
    public String accessDenied(Model m){
        m.addAttribute("error", "Access Denied");
        return "index";
    }

    @GetMapping("/")
    public String help(){
        return "index";
    }
}
