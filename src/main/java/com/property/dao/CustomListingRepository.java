package com.property.dao;

import com.property.dto.Listing;
import com.property.exception.DaoException;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Optional;

public interface CustomListingRepository {
    long insertNewListing(Listing listing) throws DaoException;
    void removeListingById(long listing_id) throws DaoException;
    void updateListing(Listing listing) throws DaoException;
    Optional<Listing> getListingById(long listing_id) throws DaoException;
    Optional<List<Listing>> getUserListings(String email) throws DaoException;
    Optional<List<Listing>> getUserListings(long id) throws DaoException;
    Optional<List<Listing>> getListingByIds(List<Long> ids) throws DaoException;

}
