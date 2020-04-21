package com.property.controller;

import com.property.controller.util.ListingFieldsMapper;
import com.property.controller.util.PropertyDetailsConverter;
import com.property.dto.Listing;
import com.property.dto.Property_Details;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.beans.PropertyEditor;
import java.time.LocalDate;
import java.util.stream.Collectors;

@Controller
public class PostListingController {
    static Logger logger = Logger.getLogger(PostListingController.class);

    @Autowired
    ListingFieldsMapper listingConverter;
    @Autowired
    PropertyDetailsConverter detailsConverter;


    @PostMapping("/post/listing.do")
    public String postNewListing(HttpSession session, @ModelAttribute Listing listing, BindingResult result){

        if (result.hasErrors()){
            logger.info("Got error from binding" + result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining()));
        }

        logger.info(listing);
        return "success";
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
