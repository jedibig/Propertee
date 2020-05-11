package com.property.dto;

import com.property.dto.Listing;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@Data
public class SearchCriteriaJPA {
    private Listing.List_For list_for;
    private Listing.Property_Type property_type;
    private String keyword;
    private BigDecimal minBudget;
    private BigDecimal maxBudget;
    private int num_bedroom;
    private Date postedBy;
}
