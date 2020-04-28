package com.property.service;

import com.property.dto.*;
import com.property.exception.DaoException;
import com.property.exception.DtoException;
import com.property.exception.ListingNotFoundException;
import com.property.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ListingService {
    /**
     *
     * @param location can be a zipcode or city
     * @return
     */
    Optional<List<Listing>> searchByLocation(String location);

    Optional<List<Listing>> searchWithCriteria(SearchCriteria criteria);

    Optional<List<Listing>> searchWithCriteria(SearchCriteria criteria, int pageNum, int pageLimit, String sortBy, boolean descending);

    Optional<Listing> getListingById(long id);

    Optional<List<Listing>> getListingFromUserId(long id);

    Optional<List<Listing>> getListingFromUserId(long id, int pageNum, int pageLimit, String sortBy, boolean descending);

    /**
     * Insert new listing into the database
     * @param listing
     * @param address
     * @param pricing
     * @param property_details
     * @param user
     * @return long. Generated Listing Id.
     * @throws DaoException
     * @throws DtoException
     */
    long insertNewListing(Listing listing, Address address, Pricing pricing, PropertyDetails property_details, User user);

}
