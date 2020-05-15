package com.property.dao.util;

import com.property.dto.Listing;
import com.property.dto.SearchCriteriaJPA;
import com.property.exception.InvalidInputException;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.Date;

public class ListingSpecification {

    public static Specification<Listing> byListFor(Listing.List_For list_for) {
        return (root, query, criteriaBuilder) ->  criteriaBuilder.equal(root.get("list_for"), list_for);
    }

    public static Specification<Listing> byPropertyType(Listing.Property_Type property_type) {
        return (root, query, criteriaBuilder) ->  criteriaBuilder.equal(root.get("property_type"), property_type);
    }

    public static Specification<Listing> byPostedDate(Date date) {
        return (root, query, criteriaBuilder) ->  criteriaBuilder.greaterThanOrEqualTo(root.get("date_listed"), date);
    }

    public static Specification<Listing> byMinBudget(BigDecimal min) {
        return (root, query, criteriaBuilder) ->  criteriaBuilder.greaterThanOrEqualTo(root.get("price"), min);
    }

    public static Specification<Listing> byMaxBudget(BigDecimal max) {
        return (root, query, criteriaBuilder) ->  criteriaBuilder.lessThanOrEqualTo(root.get("price"), max);
    }

    public static Specification<Listing> byBudgetRance(BigDecimal min, BigDecimal max) {
        return byMinBudget(min).and(byMaxBudget(max));
    }

    public static Specification<Listing> byCity(String city) {
        return (root, query, criteriaBuilder) ->  criteriaBuilder.like(root.get("city"), "%" + city + "%");
    }

    public static Specification<Listing> byProjectName(String projectName) {
        return (root, query, criteriaBuilder) ->  criteriaBuilder.like(root.get("project_name"), "%" + projectName + "%");
    }

    public static Specification<Listing> byKeyword(String keyword) {
        return byCity(keyword).or(byProjectName(keyword));
    }

    public static Specification<Listing> hassNumBedroomEquals(int num_bedroom){
        return (root, query, criteriaBuilder) ->  criteriaBuilder.equal(root.get("num_bedroom"), num_bedroom);
    }

    public static Specification<Listing> hasNumBedroomGreaterThan(int num_bedroom){
        return (root, query, criteriaBuilder) ->  criteriaBuilder.ge(root.get("num_bedroom"), num_bedroom);
    }


    public static Specification<Listing> createSpecification(SearchCriteriaJPA criteria){
        if (criteria.getKeyword() == null || criteria.getList_for() == null)
            throw new InvalidInputException();
        Specification<Listing> specification = byKeyword(criteria.getKeyword()).and(byListFor(criteria.getList_for()));

        if (criteria.getMinBudget() != null)
            specification = specification.and(byMinBudget(criteria.getMinBudget()));
        if (criteria.getMaxBudget() != null)
            specification = specification.and(byMaxBudget(criteria.getMaxBudget()));
        if (criteria.getList_for() != null)
            specification = specification.and(byListFor(criteria.getList_for()));
        if (criteria.getProperty_type() != null)
            specification = specification.and(byPropertyType(criteria.getProperty_type()));
        if (criteria.getNum_bedroom() == 6)
            specification = specification.and(hasNumBedroomGreaterThan(criteria.getNum_bedroom()));
        if (criteria.getNum_bedroom() != 0)
            specification = specification.and(hassNumBedroomEquals(criteria.getNum_bedroom()));

        return  specification;
    }

}
