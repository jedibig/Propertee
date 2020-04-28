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


    @Id @GeneratedValue @ToString.Exclude
    private long id;
    @Column(name = "name")
    private String name;
    @Column(unique = true, name="email") @Email
    private String email;
    @Column(name = "password") @Pattern(regexp = PASSWORD_PATTERN)
    private String password;
    @Column(name = "phoneNumber") @Pattern(regexp = PASSWORD_PATTERN)
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY ) @Column(name = "listing_id") @ToString.Exclude
    private List<Listing> listings;

    @Version
    private int version;
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
