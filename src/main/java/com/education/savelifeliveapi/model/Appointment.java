package com.education.savelifeliveapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="vetaccount_id")
    private VetAccount vetAccount;
    @ManyToOne
    @JoinColumn(name="useraccount_id")
    private UserAccount userAccount;
    @JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate appointmentDate;
    @JsonIgnore
    @OneToMany(mappedBy = "appointment")
    private List<Question> quizQuestions;
}
