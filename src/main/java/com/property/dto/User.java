package com.property.dto;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@Table(name = "PROPERTY_USER")
public class User {
    final static String PASSWORD_PATTERN = "";

    @Id @GeneratedValue @ToString.Exclude
    private long id;
    @Column(unique = true)
    @Email
    private String email;
    @Pattern(regexp = PASSWORD_PATTERN)
    private String password;
    private String phonenumber;
//    @OneToMany(fetch = FetchType.LAZY ) @Column(name = "listing_id") @ToString.Exclude
//    private List<Listing> listing;
    @Version
    private int version;
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
