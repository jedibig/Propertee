package com.property.service;

import com.property.dto.Listing;
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
    public Optional<List<Listing>> searchByLocation(String location) throws DaoException, DtoException;

    public Optional<Listing> getListingById(long id) throws DaoException, DtoException;

}
