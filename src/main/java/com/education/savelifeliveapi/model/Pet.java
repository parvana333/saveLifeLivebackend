package com.education.savelifeliveapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String picture;
    private String name;
    private String breed;
    private String dateOfBirth;
    private String passportNumber;
    private String remarks;
    @ManyToOne
    private UserAccount userAccount;
    private double weight;
    private double height;

}
