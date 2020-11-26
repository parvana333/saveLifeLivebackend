package com.education.savelifeliveapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class VetAccount {
    @Id
    private Long id;
    private String firstName;
    private String familyName;
    private String address;
    private String country;
    private String faxNumber;
    private String medicalCode;
    private String typeOfVet;
    private String clinicName;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;


}
