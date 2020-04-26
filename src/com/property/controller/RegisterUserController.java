package com.property.controller;

import com.property.dto.User;
import com.property.exception.DaoException;
import com.property.exception.DuplicateEmailException;
import com.property.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class RegisterUserController {

    final UserService userService;

    @PostMapping("/user/save.do")
    public String saveUser(Model m, @ModelAttribute User user, BindingResult result) throws DaoException {
        try {
            userService.insertNewUser(user);
        } catch (DuplicateEmailException e) {
            m.addAttribute("error", "Email already existed");
            return "";
        }

        return null;
    }
}
