package com.education.savelifeliveapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Question {
    @Id
    private String questionDesc;
    private String Answer;

}
