package com.property.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROPERTY_ADDRESS")
@Builder
public class Address {
    private static final String ZIPCODE_PATTERN = "^\\d{5}$";
    private static final String STATE_PATTERN = "^[A-Z]{2}$";
    private static final String CITY_PATTERN = "^([a-zA-Z\\u0080-\\u024F]+(?:. |-| |'))*[a-zA-Z\\u0080-\\u024F]*$";
    @Id
    @ToString.Exclude
    @Column(name = "listing_id")
    private long listing_id;
    @OneToOne
    @JoinColumn(name = "listing_id")
    @MapsId
    @ToString.Exclude
    private Listing listing;
    @NotEmpty
    @NotNull
    @Column(name = "street")
    private String street;
    @NotNull
    @NotEmpty
    @Column(name = "city")
    private String city;
    @NotNull
    @Pattern(regexp = STATE_PATTERN)
    @Column(name = "state")
    private String state;
    @NotNull
    @Pattern(regexp = ZIPCODE_PATTERN)
    @Column(name = "zipcode")
    private String zipcode;

    public static Address_Type getType(String input) {
        if (input.matches(ZIPCODE_PATTERN))
            return Address_Type.ZIPCODE;
        else if (input.matches(STATE_PATTERN))
            return Address_Type.STATE;
        else if (input.matches(CITY_PATTERN))
            return Address_Type.CITY;
        else
            return Address_Type.INVALID;
    }

    public enum Address_Type {
        ZIPCODE, STATE, CITY, INVALID
    }

    public enum State {
        UK("Unknown"),
        DE("Delaware"),
        HI("Hawaii"),
        PR("Puerto Rico"),
        TX("Texas"),
        PW("Palau"),
        MA("Massachusetts"),
        MD("Maryland"),
        IA("Iowa"),
        ME("Maine"),
        ID("Idaho"),
        MH("Marshall Islands"),
        MI("Michigan"),
        UT("Utah"),
        MN("Minnesota"),
        MO("Missouri"),
        IL("Illinois"),
        MP("Northern Mariana Islands"),
        IN("Indiana"),
        MS("Mississippi"),
        MT("Montana"),
        AK("Alaska"),
        AL("Alabama"),
        VA("Virginia"),
        AR("Arkansas"),
        AS("American Samoa"),
        VI("Virgin Islands"),
        NC("North Carolina"),
        ND("North Dakota"),
        NE("Nebraska"),
        RI("Rhode Island"),
        AZ("Arizona"),
        NH("New Hampshire"),
        NJ("New Jersey"),
        VT("Vermont"),
        NM("New Mexico"),
        FL("Florida"),
        FM("Federated States of Micronesia"),
        NV("Nevada"),
        WA("Washington"),
        NY("New York"),
        SC("South Carolina"),
        SD("South Dakota"),
        WI("Wisconsin"),
        OH("Ohio"),
        GA("Georgia"),
        OK("Oklahoma"),
        CA("California"),
        WV("West Virginia"),
        WY("Wyoming"),
        OR("Oregon"),
        KS("Kansas"),
        CO("Colorado"),
        GU("Guam"),
        KY("Kentucky"),
        CT("Connecticut"),
        PA("Pennsylvania"),
        LA("Louisiana"),
        TN("Tennessee"),
        DC("District of Columbia");

        private String name;


        State(String name) {
            this.name = name;
        }

        public static State valueOfName(final String name) {
            try {
                return valueOf(name.toUpperCase());
            } catch (final IllegalArgumentException e) {
                return State.UK;
            }
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
