package com.property.dto;


import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROPERTY_PRICING")
@Builder
public class Pricing {
    @Id @ToString.Exclude
    private long listing_id;
    @OneToOne
    @JoinColumn(name = "listing_id")
    @MapsId @ToString.Exclude
    private Listing listing;

    private double price;
    private double extra_charges;
    private double security_deposit;

}
