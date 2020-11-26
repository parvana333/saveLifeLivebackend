package com.education.savelifeliveapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String phone;
    private String password;
    @OneToOne
    private  VetAccount vet;
    @OneToOne
    private UserAccount user;

}
