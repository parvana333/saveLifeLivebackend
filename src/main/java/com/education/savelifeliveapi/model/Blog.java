package com.education.savelifeliveapi.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    @Lob
    private String image;
    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @ManyToOne
    private UserAccount userAccount;
    @ManyToOne
    private VetAccount vetAccount;

}

