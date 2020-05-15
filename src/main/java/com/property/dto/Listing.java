package com.property.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PROPERTY_LISTING")
@SequenceGenerator(name = "listing_id_seq", sequenceName = "listing_id_seq", initialValue = 200)
public class Listing {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "listing_id_seq")
    @Column(name = "LISTING_ID")
    private long listing_id;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;


    @Enumerated(EnumType.STRING)
    @Column(name = "list_for")
    private List_For list_for;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_type")
    private Property_Type property_type;

    @Enumerated(EnumType.STRING)
    @NotEmpty
    @Column(name = "user_type")
    private User_Type user_type;

    @Enumerated(EnumType.STRING)
    @Column(name = "apartment_subtype")
    private Apartment_Subtype apartment_subtype;

    @Enumerated(EnumType.STRING)
    @Column(name = "house_subtype")
    private House_Subtype house_subtype;



    @Column(name = "city")
    private String city;
    @Min(0) @Column(name = "price") //TODO Modify double to bigdecimal parser in controller
    private BigDecimal price;
    @Min(0) @Column(name = "area")
    private BigDecimal area;


    @Column(name = "project_name")
    private String project_name;
    @Column(name = "date_listed")
    private Date date_listed;

    @Version
    @Column(name = "version")
    private int version;

    @OneToOne(mappedBy = "listing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;
    @OneToOne(mappedBy = "listing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Pricing pricing;
    @OneToOne(mappedBy = "listing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PropertyDetails details;

    @Column(name = "postedBy")
    private String postedBy;


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
        if (user.getListings() == null)
            user.setListings(Collections.singletonList(this));
        user.getListings().add(this);
    }

    public void setAddress(Address address) {
        this.address = address;
        address.setListing(this);
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
        pricing.setListing(this);
    }

    public void setDetails(PropertyDetails details) {
        this.details = details;
        details.setListing(this);
    }
}
