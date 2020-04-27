package com.property.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Property_Details")
public class Property_Details {
    @Id @ToString.Exclude
    private long id;
    @OneToOne
    @JoinColumn(name = "listing_id")
    @MapsId
    @ToString.Exclude
    private Listing listing;
    private int area;
    @Min(0)
    private int bedroom_num;
    @Min(0)
    private int bathroom_num;
    @Min(0)
    private int balconies;
    @Min(0)
    private int total_floor;
    @Enumerated(EnumType.STRING)
    private Furnishing furnishing;
    private boolean parking;
    @Future
    private Date available_from;
    @Min(value = 0)
    private int age;

    @Builder
    public Property_Details(Listing listing, int area, int bedroom_num, int bathroom_num, int balconies, int total_floor, Furnishing furnishing, boolean parking, Date available_from, int age) {
        this.listing = listing;
        this.area = area;
        this.bedroom_num = bedroom_num;
        this.bathroom_num = bathroom_num;
        this.balconies = balconies;
        this.total_floor = total_floor;
        this.furnishing = furnishing;
        this.parking = parking;
        this.available_from = available_from;
        this.age = age;
    }



    public enum Furnishing {
        FURNISHED, UNFURNISHED, SEMIFURNISHED
    }
}
