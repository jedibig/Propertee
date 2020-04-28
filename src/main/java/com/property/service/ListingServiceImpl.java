package com.property.service;

import com.property.dao.ListingRepository;
import com.property.dao.ListingSpecification;
import com.property.dto.*;
import com.property.exception.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListingServiceImpl implements ListingService{
    static Logger logger = Logger.getLogger(ListingServiceImpl.class);

    @Autowired
    ListingRepository listingRepository;

    @Override
    public Optional<List<Listing>> searchByLocation(String location) {
        switch (Address.getType(location)){
            case CITY:
                logger.info("keyword is city");
                break;
            case STATE:
                logger.info("keyword is state");
                break;
            case ZIPCODE:
                logger.info("keyword is zipcode");
                break;
            case INVALID:
                logger.info("keyword is invalid");
                throw new UserInputException("Input does not match for city, state, or zipcode");
        }
        SearchCriteria criteria = new SearchCriteria();
        criteria.setKeyword(location);
        return searchWithCriteria(criteria);
    }

    @Override
    public Optional<List<Listing>> searchWithCriteria(SearchCriteria criteria) {
        return searchWithCriteria(criteria, 0, 10, "listing_id", false);
    }

    @Override
    public Optional<List<Listing>> searchWithCriteria(SearchCriteria criteria, int pageNum, int pageLimit, String sortBy, boolean descending) {
        if (criteria.getKeyword() == null)
            throw new InvalidInputException();
        List<Listing> listings = listingRepository.findAll( ListingSpecification.createSpecification(criteria));

        return Optional.ofNullable(listings);
    }

    @Override
    public Optional<Listing> getListingById(long id) {
        return Optional.ofNullable(listingRepository.getOne(id));
    }

    @Override
    public Optional<List<Listing>> getListingFromUserId(long id) {
        return getListingFromUserId(id, 0, 10, "listing_id", false);
    }

    @Override
    public Optional<List<Listing>> getListingFromUserId(long id, int pageNum, int pageLimit, String sortBy, boolean descending) {
        return listingRepository.findAllByUser_Id(id, ListingRepository.getPaging(pageNum, pageLimit, sortBy, descending));
    }

    @Override
    public long insertNewListing(Listing listing, Address address, Pricing pricing, PropertyDetails property_details, User user){
        listing.setAddress(address);
        listing.setPricing(pricing);
        listing.setDetails(property_details);
        listing.setUser(user);
        listing.setDate_listed(new Date());
        return listingRepository.save(listing).getListing_id();
    }
}
