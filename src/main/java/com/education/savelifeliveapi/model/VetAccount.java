package com.education.savelifeliveapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class VetAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("firstname")
    private String firstName;
    private String familyName;
    private String address;
    private String country;
    private String faxNumber;
    private String medicalCode;
    private String typeOfVet;
    private String clinicName;
    @JsonIgnore
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;
    @OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},mappedBy = "vetAccount")
    private List<Blog> blog;
    @OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},mappedBy = "vetAccount")
    private List<Appointment> appointments;
}
