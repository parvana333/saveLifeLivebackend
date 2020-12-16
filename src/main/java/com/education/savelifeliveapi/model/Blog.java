package com.education.savelifeliveapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Blog implements Serializable {
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
    @JoinColumn(name="useraccount_id")
    private UserAccount userAccount;
    @ManyToOne
    @JoinColumn(name="vetaccount_id")
    private VetAccount vetAccount;

}

