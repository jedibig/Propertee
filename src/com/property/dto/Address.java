package com.property.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROPERTY_ADDRESS")
@Builder
public class Address {
    @Id @ToString.Exclude
    private long listing_id;
    @OneToOne
    @JoinColumn(name = "listing_id")
    @MapsId
    @ToString.Exclude
    private Listing listing;
    private String street;
    private String city;
    private String state;
    private String zipcode;

    private static final String ZIPCODE_PATTERN = "^\\d{5}$";
    private static final String STATE_PATTERN = "^[A-Z]{2}$";
    private static final String CITY_PATTERN = "^([a-zA-Z\\u0080-\\u024F]+(?:. |-| |'))*[a-zA-Z\\u0080-\\u024F]*$";

    public enum Address_Type{
        ZIPCODE, STATE, CITY, INVALID
    }

    public static Address_Type getType(String input){
        if (input.matches(ZIPCODE_PATTERN))
            return Address_Type.ZIPCODE;
        else if (input.matches(STATE_PATTERN))
            return Address_Type.STATE;
        else if (input.matches(CITY_PATTERN))
            return Address_Type.CITY;
        else
            return Address_Type.INVALID;
    }
}
