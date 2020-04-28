package com.property.dto;


import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROPERTY_PRICING")
@Builder
public class Pricing {
    @Id @ToString.Exclude @Column(name = "listing_id")
    private long listing_id;
    @OneToOne
    @JoinColumn(name = "listing_id")
    @MapsId @ToString.Exclude
    private Listing listing;

    @Min(0) @NotNull @Column(name = "price")
    private BigDecimal price;
    @Min(0) @NotNull @Column(name = "extra_charges")
    private BigDecimal extra_charges;
    @Min(0) @NotNull @Column(name = "security_deposit")
    private BigDecimal security_deposit;

}
