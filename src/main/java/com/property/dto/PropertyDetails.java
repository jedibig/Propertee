package com.property.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PropertyDetails")
public class PropertyDetails {
    @Id @ToString.Exclude @Column(name = "listing_id")
    private long id;
    @OneToOne
    @JoinColumn(name = "listing_id")
    @MapsId
    @ToString.Exclude
    private Listing listing;

    @Column(name = "area")
    private BigDecimal area;
    @Min(0) @Column(name = "bedroom_num")
    private int bedroom_num;
    @Min(0) @Column(name = "bathroom_num")
    private int bathroom_num;
    @Min(0) @Column(name = "balconies")
    private int balconies;
    @Min(0) @Column(name = "total_floor")
    private int total_floor;
    @NotNull @Enumerated(EnumType.STRING) @Column(name = "furnishing")
    private Furnishing furnishing;
    @Column(name = "parking")
    private boolean parking;
    @NotNull @Future @Column(name = "available_from")
    private Date available_from;
    @Min(value = 0) @Column(name = "age")
    private int age;
    @Column(name = "description") @NotNull @NotEmpty
    private String description;


    public enum Furnishing {
        FURNISHED, UNFURNISHED, SEMIFURNISHED
    }
}
