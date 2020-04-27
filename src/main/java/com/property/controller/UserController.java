package com.property.controller;

import com.property.dto.Listing;
import com.property.dto.User;
import com.property.exception.DaoException;
import com.property.service.ListingService;
import com.property.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    static Logger logger = Logger.getLogger(UserController.class);

    UserService userService;
    ListingService listingService;

    @PostMapping("/modify")
    public String updateUserInfo(HttpSession session, @ModelAttribute User user, BindingResult result) throws DaoException {

        if (result.hasErrors()){
            logger.error("Error binding user form");
        }

        User sessionUser = (User) session.getAttribute("user");

        User updatedUser = userService.applyDifferences(sessionUser, user).orElse(sessionUser);

        if (updatedUser != sessionUser){
            userService.updateUser(updatedUser);
        }

        //TODO user profile view
        return "";
    }

    @GetMapping("/listings")
    public String getUserListings(HttpSession session, Model m) throws DaoException {

        User user = (User) session.getAttribute("user");

        Optional<List<Listing>> userListing = listingService.getListingFromUserId(user.getId());

        if(userListing.isPresent()){

        }

        m.addAttribute("removable", true);
        return "search_result";
    }
}
