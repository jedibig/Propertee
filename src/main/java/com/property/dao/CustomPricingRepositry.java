package com.property.dao;

import com.property.dto.Listing;
import com.property.dto.Pricing;
import com.property.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface CustomPricingRepositry {
    void updatePricing(Pricing pricing) throws DaoException;
    Optional<List<Listing>> getListingWithPriceRange(double minVal, double maxVal) throws DaoException;
    Optional<List<Listing>> getListingWithTotalPriceRange(double minVal, double maxVal) throws DaoException;
}
