package com.property.controller;

import com.property.controller.util.ListingFieldsMapper;
import com.property.controller.util.PropertyDetailsConverter;
import com.property.dto.*;
import com.property.exception.DaoException;
import com.property.exception.DtoException;
import com.property.service.ListingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class PostListingController {
    static Logger logger = Logger.getLogger(PostListingController.class);

    final ListingFieldsMapper listingConverter;
    final PropertyDetailsConverter detailsConverter;
    final ListingService listingService;

    public PostListingController(ListingFieldsMapper listingConverter, PropertyDetailsConverter detailsConverter, ListingService listingService) {
        this.listingConverter = listingConverter;
        this.detailsConverter = detailsConverter;
        this.listingService = listingService;
    }


    @PostMapping("/post/listing.do")
    public String postNewListing(Model m, @ModelAttribute Listing listing, BindingResult listingResult,
                                 @ModelAttribute Address address, BindingResult addressResult,
                                 @ModelAttribute User user, BindingResult userResult,
                                 @ModelAttribute Property_Details property_details, BindingResult detailsResult,
                                 @ModelAttribute Pricing pricing, BindingResult pricingResult) throws DaoException {

//        if (result.hasErrors()){
//            logger.info("Got error from binding" + result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining()));
//        }

        try {
            long listing_id = listingService.insertNewListing(listing, address, pricing, property_details, user);
            m.addAttribute("listing_id", listing_id);
            m.addAttribute("email", user.getEmail());

        } catch (DtoException e) {
            e.printStackTrace();
        }

        logger.info(listing);
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
        dataBinder.registerCustomEditor(Property_Details.Furnishing.class, detailsConverter.furnishingConverter);
        dataBinder.registerCustomEditor(LocalDate.class, detailsConverter.dateConverter);
    }


}
