package com.property.spring;

import com.property.dao.AddressRepository;
import com.property.dao.ListingRepository;
import com.property.dao.UserRepository;
import com.property.dto.Listing;
import com.property.dto.Listing.*;
import com.property.dto.User;
import com.property.exception.DaoException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
    public static void main(String[] args) throws DaoException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ListingRepository lrepo = context.getBean(ListingRepository.class);
        AddressRepository arepo = context.getBean(AddressRepository.class);
        UserRepository urepo = context.getBean(UserRepository.class);

        Listing listing = Listing.builder()
//                .address(Address.builder().city("Irvine").state("CA").street("870 Veneto").zipcode("92614").build())
                .list_for(List_For.RENT)
                .property_type(Listing.Property_Type.APARTMENT)
                .user_type(Listing.User_Type.OWNER)
//                .pricing(Pricing.builder().price(4000.50).extra_charges(50.00).build())
                .build();
//        listing.getAddress().setListing(listing);
//        listing.getPricing().setListing(listing);
        User user = urepo.getUserById(2);
        user.getListing().add(listing);
        listing.setUser(user);
        listing.getUser().getListing().add(listing);

        try {
//            lrepo.insertNewListing(listing);
            System.out.println(arepo.getListingByCity("Irvine"));
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
