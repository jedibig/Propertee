//package com.property.controller;
//
//import com.property.dto.User;
//import com.property.exception.DaoException;
//import com.property.exception.DuplicateEmailException;
//import com.property.exception.UserNotLoggedInException;
//import com.property.service.ListingService;
//import com.property.service.UserService;
//import lombok.AllArgsConstructor;
//import java.util.logging.Logger;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//import java.util.Optional;
//
//@Controller
//@AllArgsConstructor
//@RequestMapping("/user")
//public class UserController {
//    static Logger logger = Logger.getLogger(UserController.class.getName());
//
//    UserService userService;
//    ListingService listingService;
//
//    @PostMapping("/modify")
//    public String updateUserInfo(HttpSession session, @ModelAttribute User user, BindingResult result) throws DaoException {
//
//        if (result.hasErrors()){
//            logger.severe("Error binding user form");
//        }
//
//        User sessionUser = (User) session.getAttribute("user");
//
//        User updatedUser = userService.applyDifferences(sessionUser, user).orElse(sessionUser);
//
//        if (updatedUser != sessionUser){
//            userService.updateUser(updatedUser);
//        }
//
//        //TODO user profile view
//        return "";
//    }
//
//    @GetMapping("/listings")
//    public String getUserListings(HttpSession session, Model m) throws DaoException {
//
//        if (userIsLoggedIn(session)){
//            User user = (User) session.getAttribute("user");
//            m.addAttribute("isempty", false);
//            listingService.getListingFromUserId(user.getId()). ifPresent(l ->
//                m.addAttribute("listings", l));
//        }
//        return "search_result";
//    }
//
//    @PostMapping("/login")
//    public String validateUserInfo(Model m, @RequestParam("email") String email, @RequestParam("password") String password,
//                                   HttpSession session) {
//        if (session.getAttribute("user") != null) {
//            m.addAttribute("error", "User already logged in. Please logout to log in to another account");
//        } else {
//            Optional<User> validatedUser = userService.validateUser(User.builder().email(email).password(password).build());
//            if(validatedUser.isPresent()){
//                session.setAttribute("user", validatedUser.get());
//                return "index";
//            } else {
//                m.addAttribute("error", "Invalid username, password or both");
//            }
//        }
//        return "login";
//    }
//
//    @PostMapping("/register")
//    public String saveUser(Model m, @ModelAttribute User user, @RequestParam("psw-repeat") String pswmatch, BindingResult result) {
//        if (pswmatch.equals(user.getPassword())){
//            try {
//                userService.insertNewUser(user);
//                m.addAttribute("info","User registered successfully. Please log in.");
//                return "index";
//            } catch (DuplicateEmailException e) {
//                m.addAttribute("error", "Email already existed");
//            }
//        } else {
//            m.addAttribute("error", "Password mismatch");
//        }
//        return "register-form";
//    }
//
//    public boolean userIsLoggedIn(HttpSession session){
//        if (session.getAttribute("user") == null)
//            throw new UserNotLoggedInException();
//        return true;
//    }
//}
