package com.property.dao;

import com.property.dto.Address;
import com.property.dto.Listing;
import com.property.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    void updateAddress(Address address) throws DaoException;
    Optional<List<Long>> getListingByCity(String city) throws DaoException;
    Optional<List<Long>> getListingByZipcode(String zipcode) throws DaoException;
    Optional<List<Long>> getListingByState(String state) throws DaoException;
}
