package com.property.service;

import com.property.dao.ListingRepository;
import com.property.dao.util.ListingSpecification;
import com.property.dto.*;
import com.property.exception.*;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListingServiceImpl implements ListingService{
    static Logger logger = Logger.getLogger(ListingServiceImpl.class.getName());

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
        SearchCriteriaJPA criteria = new SearchCriteriaJPA();
        criteria.setKeyword(location);
        return searchWithCriteria(criteria);
    }

    @Override
    public Optional<List<Listing>> searchWithCriteria(SearchCriteriaJPA criteria) {
        return searchWithCriteria(criteria, 0, 10, "listing_id", false);
    }

    @Override
    public Optional<List<Listing>> searchWithCriteria(SearchCriteriaJPA criteria, int pageNum, int pageLimit, String sortBy, boolean descending) {
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
    @Modifying
    public long insertNewListing(Listing listing, Address address, Pricing pricing, PropertyDetails property_details, User user){
        listing.setAddress(address);
        listing.setPricing(pricing);
        listing.setDetails(property_details);
        listing.setUser(user);
        listing.setDate_listed(new Date());

        ListingElastic elastic = new ListingElastic();
        elastic.setAddress(address.getStreet() +" "+ address.getCity() +" "+ address.getState() +" "+ address.getZipcode());
        elastic.setArea(listing.getArea());
        elastic.setDate_listed(listing.getDate_listed());
        elastic.setDescription(property_details.getDescription());
        elastic.setTags(new String[]{address.getStreet(), address.getCity(), address.getState(), address.getZipcode()});


        return listingRepository.save(listing).getListing_id();
    }
}
