package com.property.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutUserController {
    static Logger logger = Logger.getLogger(LogoutUserController.class);

    @GetMapping("/logout")
    public String invalidateSession(HttpRequest request, HttpSession session){

        String URI = request.getURI().toString();
        session.invalidate();

        return "redirect:" + URI;
    }

}
