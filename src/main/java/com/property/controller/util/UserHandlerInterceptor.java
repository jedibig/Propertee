package com.property.controller.util;

import com.property.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@AllArgsConstructor
@Component
@ConditionalOnClass(UserService.class)
public class UserHandlerInterceptor  extends HandlerInterceptorAdapter {

    final UserService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getUserPrincipal() == null)
            response.sendRedirect("/login");

        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null)
            session.setAttribute("user", service.getUserIdFromEmail(request.getUserPrincipal().getName()));

        return true;
    }
}
