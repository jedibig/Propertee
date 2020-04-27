package com.property.controller;

import com.property.dto.Listing;
import com.property.exception.DaoException;
import com.property.exception.DtoException;
import com.property.service.ListingService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class SearchController {
    static Logger logger = Logger.getLogger(SearchController.class);

    final ListingService listingService;

    public SearchController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping("/search/location.do")
    public String searchOnLocation(HttpSession session, @RequestParam("keyword") String keyword,  Model m) throws DaoException {
        logger.info("Receive request to search based on location.");

        try {
            List<Listing> listings = listingService.searchByLocation(keyword).orElse(Collections.emptyList());
            if (listings.isEmpty()){
                logger.info("No listing found;");
                m.addAttribute("isempty", true);
            }
            logger.info("Found " + listings.size() + " listing with matching criteria");
            m.addAttribute("listings", listings);
            m.addAttribute("removable", false);

            return "search_result";

        } catch (DtoException e) {
            logger.error("got error message" + e.getMessage());
            m.addAttribute("error", e.getMessage());
            return "index";
        }

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        logger.error(name + " parameter is missing");
        return "defaulterror";
    }
}
