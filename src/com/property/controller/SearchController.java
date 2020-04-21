package com.property.controller;

import com.property.dto.Listing;
import com.property.exception.DaoException;
import com.property.exception.DtoException;
import com.property.service.ListingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public ModelAndView searchOnLocation(HttpSession session, @RequestParam("keyword") String keyword){
        logger.info("Receive request to search based on location.");
        ModelAndView mv = new ModelAndView();

        try {
            List<Listing> listings = listingService.searchByLocation(keyword).orElse(Collections.emptyList());
            logger.info("Got these listings: " + listings);
            mv.setViewName("search_result");
            mv.addObject("listings", listings);
        } catch (DaoException e) {
            mv.setViewName("daoerror");
        } catch (DtoException e) {
            mv.setViewName("home_search");
            mv.addObject("error", e.getMessage());
        }

        return mv;
    }
}
