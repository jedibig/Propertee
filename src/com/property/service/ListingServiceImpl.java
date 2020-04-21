package com.property.service;

import com.property.dao.AddressRepository;
import com.property.dao.ListingRepository;
import com.property.dto.Address;
import com.property.dto.Listing;
import com.property.exception.DaoException;
import com.property.exception.DtoException;
import com.property.exception.UserInputException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingServiceImpl implements ListingService{
    static Logger logger = Logger.getLogger(ListingServiceImpl.class);

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ListingRepository listingRepository;

    @Override
    public Optional<List<Listing>> searchByLocation(String location) throws DaoException, DtoException {
        Optional<List<Long>> listingIds = Optional.empty();
        switch (Address.getType(location)){
            case CITY:
                logger.info("keyword is city");
                listingIds = addressRepository.getListingByCity(location);
                break;
            case STATE:
                logger.info("keyword is state");
                listingIds = addressRepository.getListingByState(location);
                break;
            case ZIPCODE:
                logger.info("keyword is zipcode");
                listingIds = addressRepository.getListingByZipcode(location);
                break;
            case INVALID:
                logger.info("keyword is invalid");
                throw new UserInputException("Input does not match for city, state, or zipcode");
        }
        return listingIds.isPresent() ? listingRepository.getListingByIds(listingIds.get()) : Optional.empty();
    }

    @Override
    public Optional<Listing> getListingById(long id) throws DaoException {
        return listingRepository.getListingById(id);
    }
}
