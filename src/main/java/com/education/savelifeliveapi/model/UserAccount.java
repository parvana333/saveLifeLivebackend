package com.education.savelifeliveapi.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserAccount {
    @Id
    private Long id;
    private String firstName;
    private String familyName;
    private String address;
    private String country;
    private String gender;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;
    @OneToMany(mappedBy ="userAccount")
    private List<Pet> pet;
    private int petsNumber;
    private boolean addsOn;
    private boolean premiumOn;

}
