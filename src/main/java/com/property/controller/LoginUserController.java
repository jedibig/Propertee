package com.property.controller;

import com.property.dto.User;
import com.property.exception.DaoException;
import com.property.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class LoginUserController {
    static Logger logger = Logger.getLogger(LoginUserController.class);

    final UserService userService;

    @PostMapping()
    public String validateUserInfo(Model m, @ModelAttribute User user, BindingResult result, HttpSession session) throws DaoException {

        Optional<User> validatedUser = userService.validateUser(user);

        if(validatedUser.isPresent()){
            session.setAttribute("user", validatedUser.get());
        } else {
            m.addAttribute("error", "Invalid username, password or both");
        }

        return "";
    }
}
