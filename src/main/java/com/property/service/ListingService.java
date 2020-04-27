package com.property.service;

import com.property.dto.*;
import com.property.exception.DaoException;
import com.property.exception.DtoException;
import com.property.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ListingService {
    /**
     *
     * @param location can be a zipcode or city
     * @return
     */
    Optional<List<Listing>> searchByLocation(String location) throws DaoException, DtoException;

    Optional<Listing> getListingById(long id) throws DaoException, DtoException;

    Optional<List<Listing>> getListingFromUserId(long id) throws DaoException, UserNotFoundException;

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
    long insertNewListing(Listing listing, Address address, Pricing pricing, Property_Details property_details, User user) throws DaoException, DtoException;


}
