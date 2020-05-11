package com.property.controller;

import java.util.logging.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutUserController {
    static Logger logger = Logger.getLogger(LogoutUserController.class.getName());

    @GetMapping("/logout")
    public String invalidateSession(HttpRequest request, HttpSession session){

        String URI = request.getURI().toString();
        session.invalidate();

        return "redirect:" + URI;
    }

}
