package com.property.dao;

import com.property.dto.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyDetailsRepository extends JpaRepository<PropertyDetails, Long> {
}
