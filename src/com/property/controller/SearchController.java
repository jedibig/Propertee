package com.property.controller;

import com.property.dto.Listing;
import com.property.exception.DaoException;
import com.property.exception.DtoException;
import com.property.service.ListingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class SearchController {
    static Logger logger = Logger.getLogger(SearchController.class);

    @Autowired
    ListingService listingService;

    @GetMapping("/search/location.do")
    public String searchOnLocation(HttpSession session, @RequestParam("keyword") String keyword, Model m) throws DaoException {
        logger.info("Receive request to search based on location.");

        try {
            List<Listing> listings = listingService.searchByLocation(keyword).orElse(Collections.emptyList());
            if (listings.isEmpty()){
                m.addAttribute("isempty", true);
            }
            m.addAttribute("listings", listings);
            return "search_result";
        } catch (DtoException e) {
            m.addAttribute("error", e.getMessage());
            return "index";
        }

    }
}
