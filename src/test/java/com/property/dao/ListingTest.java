package com.property.dao;

import com.property.SpringBootConfigurer;
import com.property.dto.Address;
import com.property.dto.Listing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@WebAppConfiguration
@ContextConfiguration(classes = SpringBootConfigurer.class)
public class ListingTest {

    @Autowired
    ListingRepository listingRepository;
    @Autowired
    TestEntityManager manager;

    @BeforeEach
    public void loadData(){
        manager.persist(Listing.builder().address(Address.builder().city("Angeles").build()).build());

    }

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
