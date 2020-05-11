package com.property.controller.util;

import com.property.exception.ControllerException;
import com.property.exception.DaoException;
import com.property.exception.UserNotLoggedInException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DaoException.class)
    public String daoExceptionHandler(){
        return "daoerror";
    }

    @ExceptionHandler(UserNotLoggedInException.class)
    public String notAuthorizedExceptionHandler(Model m){
        m.addAttribute("error", "Must be logged in to access this page.");
        return "index";
    }

    @ExceptionHandler(ControllerException.class)
    public String controllerExceptionHandler(){
        return "defaulterror";
    }
}
