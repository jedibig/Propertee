package com.property.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PROPERTY_LISTING")
public class Listing {
    @Id @GeneratedValue
    private long listing_id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @Enumerated(EnumType.STRING)
    private List_For list_for;
    @Enumerated(EnumType.STRING)
    private Property_Type property_type;
    @Enumerated(EnumType.STRING)
    private User_Type user_type;
    @Enumerated(EnumType.STRING)
    private Apartment_Subtype apartment_subtype;
    @Enumerated(EnumType.STRING)
    private House_Subtype house_subtype;

    private String city;
    private double price;
    private int area;

    @Version
    private int version;

    private String description;
    @OneToOne(mappedBy = "listing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;
    @OneToOne(mappedBy = "listing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Pricing pricing;
    @OneToOne(mappedBy = "listing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Property_Details details;

    private LocalDate date_listed;


    public enum User_Type{
        OWNER, DEALER
    }

    public enum Property_Type{
        APARTMENT, HOUSE, OTHERS
    }

    public enum List_For{
        SELL, RENT
    }

    public enum Apartment_Subtype{
        RESIDENTIAL, INDEPENDENT, STUDIO, SERVICED
    }

    public enum House_Subtype{
        INDEPENDENT, FARM
    }

    public void setUser(User user) {
        this.user = user;
        List<Listing> list = user.getListing();
        if (list == null){
            list = new LinkedList<>();
        }
        list.add(this);
    }

    public void setAddress(Address address) {
        this.address = address;
        address.setListing(this);
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
        pricing.setListing(this);
    }

    public void setDetails(Property_Details details) {
        this.details = details;
        details.setListing(this);
    }
}
