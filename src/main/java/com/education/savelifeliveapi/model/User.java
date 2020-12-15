package com.education.savelifeliveapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("username")
    @Column(name="username")
    private String username;
    private String email;
    private String phone;
    private String password;
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private  VetAccount vetAccount;
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private UserAccount userAccount;



}
