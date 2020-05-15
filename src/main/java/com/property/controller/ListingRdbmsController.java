package com.property.controller;

import com.property.controller.util.EnumTypeConverter;
import com.property.dto.*;
import com.property.exception.DaoException;
import com.property.service.ListingService;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@NoArgsConstructor
@Setter
@RequestMapping("/listings")
public class ListingRdbmsController {
    static Logger logger = Logger.getLogger(ListingRdbmsController.class.getName());

    @Autowired ListingService listingService;

    //TODO change jsp mapping for listings services
    @GetMapping("/{id}")
    public String getListing(Model m, @PathVariable(name = "id") long listing_id)  {

        logger.info("Getting listing from id: " + listing_id);
        Optional<Listing> listing = listingService.getListingById(listing_id);
        if (!listing.isPresent()){
            m.addAttribute("error", "No listing found with that id");
            return "index";
        }
        m.addAttribute("listing", listing.get());
        logger.info("Done serving request to get listing");
        return "single_property";
    }

    @GetMapping("/new/form")
    public String checkUserCredentials(){
        return "post_property";
    }

    @PostMapping("/new")
    public String postNewListing(Model m,  Principal principal,
                                 @ModelAttribute Listing listing, BindingResult listingResult,
                                 @ModelAttribute Address address, BindingResult addressResult,
                                 @ModelAttribute PropertyDetails property_details, BindingResult detailsResult,
                                 @ModelAttribute Pricing pricing, BindingResult pricingResult,
                                 @ModelAttribute User user, BindingResult userResult) throws DaoException {

        Stream.of(listingResult, addressResult, detailsResult, pricingResult, userResult)
                .filter(Errors::hasErrors)
                .forEach(e -> {
                    logger.info("Got error from binding" + e.getAllErrors().stream()
                            .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining()));
                });

        String admin = principal.getName();
        listing.setPostedBy(admin);
        long listing_id = listingService.insertNewListing(listing, address, pricing, property_details, user);
        m.addAttribute("listing_id", listing_id);
        m.addAttribute("email", admin);


        logger.info(listing.toString());
        //TODO create success page
        return "add_listing_success";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Listing.Property_Type.class, new EnumTypeConverter<>(Listing.Property_Type.class));
        dataBinder.registerCustomEditor(Listing.User_Type.class, new EnumTypeConverter<>(Listing.User_Type.class));
        dataBinder.registerCustomEditor(Listing.List_For.class, new EnumTypeConverter<>(Listing.List_For.class));
        dataBinder.registerCustomEditor(Listing.House_Subtype.class, new EnumTypeConverter<>(Listing.House_Subtype.class));
        dataBinder.registerCustomEditor(Listing.Apartment_Subtype.class, new EnumTypeConverter<>(Listing.Apartment_Subtype.class));
        dataBinder.registerCustomEditor(PropertyDetails.Furnishing.class, new EnumTypeConverter<>(PropertyDetails.Furnishing.class));
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(DateFormat.getDateInstance(), false));
    }
}
