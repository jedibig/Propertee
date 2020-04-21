package com.property.dto;

import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class User_Listing {
    @OneToOne
    private User user;
    private Listing listing;
    private String user_type;
    // sell rent
    private String list_for;
}
