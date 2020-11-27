package com.education.savelifeliveapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Appointment {
    @Id
    private Long id;
    @ManyToOne
    private VetAccount vetAccount;
    @ManyToOne
    private UserAccount userAccount;
    private LocalDateTime appointmentDate;
    @OneToMany
    private List<Question> quizQuestions;
}
