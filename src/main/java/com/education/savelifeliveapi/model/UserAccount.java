package com.education.savelifeliveapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class UserAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String familyName;
    private String address;
    private String country;
    private String gender;
    @JsonIgnore
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy ="userAccount")
    private List<Pet> pet;
    private int petsNumber;
    private boolean addsOn;
    private boolean premiumOn;
    @JsonIgnore
    @OneToMany(mappedBy = "userAccount")
    private List<Blog> blog;
    @JsonIgnore
    @OneToMany(mappedBy = "userAccount")
    private List<Appointment> appointments;


}
