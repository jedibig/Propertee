package com.property.controller;

import com.property.controller.util.ListingFieldsMapper;
import com.property.controller.util.PropertyDetailsConverter;
import com.property.dto.*;
import com.property.exception.DaoException;
import com.property.exception.DtoException;
import com.property.exception.InvalidInputException;
import com.property.service.ListingService;

import java.time.LocalDate;
import java.util.logging.Logger;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
@RequestMapping("/listings")
public class GetListingController {
    static Logger logger = Logger.getLogger(GetListingController.class.getName());

    final ListingFieldsMapper listingConverter;
    final PropertyDetailsConverter detailsConverter;
    final ListingService listingService;

    //TODO change jsp mapping for listings services
    @GetMapping("/{id}}")
    public String getListing(Model m, @PathVariable(name = "id") long listing_id) throws DaoException {

        try {
            logger.info("Getting listing from id: " + listing_id);
            Listing listing = listingService.getListingById(listing_id).orElseThrow(() -> new DtoException("Listing not found."));
            m.addAttribute("listing", listing);
            logger.info("Done serving request to get listing");
            return "single_property";
        } catch (DtoException e) {
            logger.severe(e.getMessage());
            return "dtoerror";
        }
    }

    @GetMapping("/post/form")
    public String checkUserCredentials(Model m, HttpSession session){
        return "post_property";
    }

    @PostMapping("/post/save")
    public String postNewListing(Model m, HttpSession session,
                                 @ModelAttribute Listing listing, BindingResult listingResult,
                                 @ModelAttribute Address address, BindingResult addressResult,
                                 @ModelAttribute PropertyDetails property_details, BindingResult detailsResult,
                                 @ModelAttribute Pricing pricing, BindingResult pricingResult) throws DaoException {
        if (Stream.of(listingResult, detailsResult, addressResult, pricingResult).anyMatch(Errors::hasErrors)){
            throw new InvalidInputException();
        }


        try {
            User user  = (User) session.getAttribute("user");
            long listing_id = listingService.insertNewListing(listing, address, pricing, property_details, user);
            m.addAttribute("listing_id", listing_id);
            m.addAttribute("email", user.getEmail());

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
