package com.property.dto;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@Table(name = "PROPERTY_USER")
public class User {
    //TODO User fields pattern
    final static String PASSWORD_PATTERN = "";
    final static String PHONENUMBER_PATTERN = "";

    @Id @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;
    @Column(unique = true, name="email")
    private String email;
    @Column(name = "password")
    private String about;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY )
    @Column(name = "listing_id") @ToString.Exclude
    private List<Listing> listings;


    @Version @ToString.Exclude
    private int version;

}
