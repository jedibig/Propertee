package com.property.dao;

import com.property.dto.Listing;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long>, JpaSpecificationExecutor {
    Optional<List<Listing>> findAllByUser_Id(long userId, Pageable paging);
    Optional<List<Listing>> findAllByAddress_CityIgnoreCaseContains(String keyword);


    static Pageable getPaging(int pageNum, int pageLimit, String sortBy, boolean descending){
        return PageRequest.of(pageNum, pageLimit, descending ? Sort.Direction.DESC : Sort.Direction.ASC, sortBy);
    }
}
