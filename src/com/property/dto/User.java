package com.property.dto;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
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
    @Id @GeneratedValue @ToString.Exclude
    private long id;
    @Column(unique = true)
    private String email;
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
