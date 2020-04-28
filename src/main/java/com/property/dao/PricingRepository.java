package com.property.dao;

import com.property.dto.Listing;
import com.property.dto.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingRepository extends JpaRepository<Pricing, Long> {
}
