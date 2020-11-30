package com.education.savelifeliveapi.controller;

import com.education.savelifeliveapi.exception.AlreadyExistException;
import com.education.savelifeliveapi.exception.EmailExistException;
import com.education.savelifeliveapi.exception.ExceptionEntity;
import com.education.savelifeliveapi.exception.UserNameExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
@ResponseStatus(HttpStatus.BAD_REQUEST)
@Slf4j
public class ExceptionController {
    @org.springframework.web.bind.annotation.ExceptionHandler(AlreadyExistException.class)
    public ExceptionEntity handleAlreadyExistException(){
        //log.info(ex.getMessage());
        return ExceptionEntity.builder()
                .code(409)
                .description("Already exists")
                .build();
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(EmailExistException.class)
    public ExceptionEntity handleEmailExistException(){
       // log.info(ex.getMessage());
        return ExceptionEntity.builder()
                .code(409)
                .description("")
                .build();
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNameExistException.class)
    public ExceptionEntity handleUserNameExistException(){
        //log.info(ex.getMessage());
        return ExceptionEntity.builder()
                .code(409)
                .description("")
                .build();
    }
}
