package com.education.savelifeliveapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Pet implements Serializable {
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
    @JsonIgnore
    @ManyToOne
    private UserAccount userAccount;
    private double weight;
    private double height;

}
