package com.property.daospring;

import com.property.dao.ListingRepository;
import com.property.dto.Listing;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ListingTest {
    @Autowired
    ListingRepository listingRepository;

    @Test
    public void testQuery(){
        Optional<List<Listing>> listing = listingRepository.findAllByAddress_CityIgnoreCaseContains("Angeles");
        Assert.isTrue(listing.isPresent(), "Not Found");
    }

    @Test
    public void testQuery2(){
        Optional<List<Listing>> listing = listingRepository.findAllByUser_Id(1, PageRequest.of(0,10));
        Assert.isTrue(listing.isPresent(), "Not Found");
    }

}
