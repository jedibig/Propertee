package com.property.service;

import com.property.dto.Address;
import com.property.dto.Listing;
import com.property.dto.Pricing;
import com.property.dto.Property_Details;
import com.property.exception.DaoException;
import com.property.exception.DtoException;

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

    /**
     * Insert new listing into the database
     * @param listing
     * @param address
     * @param pricing
     * @param property_details
     * @return long. Generated Listing Id.
     * @throws DaoException
     * @throws DtoException
     */
    long insertNewListing(Listing listing, Address address, Pricing pricing, Property_Details property_details) throws DaoException, DtoException;

}
