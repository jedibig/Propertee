package com.property.controller;

import com.property.controller.util.ModelAttributeName;
import com.property.controller.util.SessionAttributeName;
import com.property.controller.util.UserHandlerInterceptor;
import com.property.controller.util.ViewName;
import com.property.dto.Listing;
import com.property.dto.User;
import com.property.service.ListingService;
import com.property.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
@ConditionalOnClass(UserHandlerInterceptor.class)
public class UserController {
    static Logger logger = Logger.getLogger(UserController.class.getName());

    UserService userService;
    ListingService listingService;

    @PostMapping(value = {"/modify", "/details/update"})
    public String updateUserInfo(HttpSession session,
                                 @ModelAttribute User user, BindingResult result) {

        if (result.hasErrors()){
            logger.severe("Error binding user form");
            return ViewName.DEFAULT_ERROR_PAGE;
        }

        long id = (long) session.getAttribute(SessionAttributeName.USER_ID);

        if (user.getId() != id){
            logger.severe("Not matching logged in email address");
            return ViewName.DEFAULT_ERROR_PAGE;
        }

        userService.updateUser(user);

        return ViewName.USER_DETAILS_PAGE;
    }

    @GetMapping("/listings")
    public String getUserListings(HttpSession session, Model m){

        long id = (long) session.getAttribute(SessionAttributeName.USER_ID);

        Optional<List<Listing>> optional = listingService.getListingFromUserId(id);
        m.addAttribute(ModelAttributeName.LISTINGS_NOT_FOUND, optional.isPresent());

        if (!optional.isPresent())
            m.addAttribute(ModelAttributeName.ERROR_MESSAGE, "No Listing yet, please post listing.");
        else
            m.addAttribute(ModelAttributeName.LIST_LISTINGS, optional.get());

        return ViewName.SEARCH_RESULT_PAGE;
    }

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

//    @GetMapping("/logout")
//    public String invalidateSession(HttpRequest request, HttpSession session){
//
//        String URI = request.getURI().toString();
//        session.invalidate();
//
//        return "redirect:" + URI;
//    }

//    public boolean userIsLoggedIn(HttpSession session){
//        if (session.getAttribute("user") == null)
//            throw new UserNotLoggedInException();
//        return true;
//    }
}
