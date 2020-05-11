package com.property.controller;

import com.property.controller.util.ListingFieldsMapper;
import com.property.controller.util.PropertyDetailsConverter;
import com.property.dto.*;
import com.property.exception.DaoException;
import com.property.exception.DtoException;
import com.property.service.ListingService;
import lombok.AllArgsConstructor;

import java.security.Principal;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@AllArgsConstructor
public class PostListingController {
    static Logger logger = Logger.getLogger(PostListingController.class.getName());

    final ListingFieldsMapper listingConverter;
    final PropertyDetailsConverter detailsConverter;
    final ListingService listingService;


    @GetMapping("/listings/new/form")
    public String checkUserCredentials(Model m, HttpSession session){
//        if (session.getAttribute("user") == null){
//            m.addAttribute("error", "Must login to post a listing.");
//            return "login";
//        }

        return "post_property";
    }

    @PostMapping("/post/listing.do")
    @PutMapping("/listings/new")
    public String postNewListing(Model m, HttpSession session, Principal principal,
                                 @ModelAttribute Listing listing, BindingResult listingResult,
                                 @ModelAttribute Address address, BindingResult addressResult,
                                 @ModelAttribute PropertyDetails property_details, BindingResult detailsResult,
                                 @ModelAttribute Pricing pricing, BindingResult pricingResult,
                                 @ModelAttribute User user, BindingResult userResult) throws DaoException {

//        if (result.hasErrors()){
//            logger.info("Got error from binding" + result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining()));
//        }

        try {
            String admin = principal.getName();
            listing.setPostedBy(admin);
            long listing_id = listingService.insertNewListing(listing, address, pricing, property_details, user);
            m.addAttribute("listing_id", listing_id);
            m.addAttribute("email", admin);

        } catch (DtoException e) {
            e.printStackTrace();
        }

        logger.info(listing.toString());
        //TODO create success page
        return "add_listing_success";
    }


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Listing.Property_Type.class, listingConverter.propertyTypeConverter);
        dataBinder.registerCustomEditor(Listing.User_Type.class, listingConverter.userTypeConverter);
        dataBinder.registerCustomEditor(Listing.List_For.class, listingConverter.listForConverter);
        dataBinder.registerCustomEditor(Listing.House_Subtype.class, listingConverter.houseSubtypeConverter);
        dataBinder.registerCustomEditor(Listing.Apartment_Subtype.class, listingConverter.apartmentSubtypeConverter);
        dataBinder.registerCustomEditor(PropertyDetails.Furnishing.class, detailsConverter.furnishingConverter);
        dataBinder.registerCustomEditor(LocalDate.class, detailsConverter.dateConverter);
    }


}
