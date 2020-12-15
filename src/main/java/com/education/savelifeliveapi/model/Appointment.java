package com.education.savelifeliveapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="vetaccount_id")
    private VetAccount vetAccount;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="useraccount_id")
    private UserAccount userAccount;
    private LocalDateTime appointmentDate;
    @OneToMany(mappedBy = "appointment")
    private List<Question> quizQuestions;
}
