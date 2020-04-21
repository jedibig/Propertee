package com.property.controller;

import com.property.dto.Listing;
import com.property.exception.DaoException;
import com.property.exception.DtoException;
import com.property.service.ListingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;

@Controller
public class GetListingController {
    static Logger logger = Logger.getLogger(GetListingController.class);
    @Autowired
    ListingService listingService;

    @GetMapping("/get/listing.do")
    public String getListing(Model m, @RequestParam("listing_id") long listing_id, BindingResult result){
        if (result.hasErrors()){
            logger.info("Got error from binding" + result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining()));
        }

        try {
            logger.info("Getting listing from id: " + listing_id);
            Listing listing = listingService.getListingById(listing_id).orElseThrow(() -> new DtoException("Listing not found."));
            m.addAttribute("listing", listing);
            logger.info("Done serving request to get listing");
            return "single_listing";
        } catch (DaoException e) {
            logger.error(e.getMessage());
            return "daoerror";
        } catch (DtoException e) {
            logger.error(e.getMessage());
            return "dtoerror";
        }

    }
}
