package com.property.controller;

import com.property.controller.util.ListingFieldsMapper;
import com.property.dto.Listing;
import com.property.dto.SearchCriteria;
import com.property.exception.DaoException;
import com.property.exception.DtoException;
import com.property.service.ListingService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {
    static Logger logger = Logger.getLogger(SearchController.class);

    final ListingService listingService;
    final ListingFieldsMapper listingConverter;



    @GetMapping("/location.do")
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

    @GetMapping("/filter")
    public String searchOnCrieria(Model m, @ModelAttribute SearchCriteria criteria, BindingResult result, @RequestParam("page") String page){
        logger.info("Receive request to search with criteria.");

        logger.info(criteria);
        List<Listing> listings = listingService.searchWithCriteria(criteria).orElse(Collections.emptyList());
        if (listings.isEmpty()){
            logger.info("No listing found;");
            m.addAttribute("isempty", true);
        }
        logger.info("Found " + listings.size() + " listing with matching criteria");
        m.addAttribute("listings", listings);
        m.addAttribute("removable", false);

        return "search_result";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        logger.error(name + " parameter is missing");
        return "defaulterror";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Listing.List_For.class, listingConverter.listForConverter);
    }
}
