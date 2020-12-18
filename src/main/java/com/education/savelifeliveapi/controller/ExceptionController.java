package com.education.savelifeliveapi.controller;

import com.education.savelifeliveapi.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
        return ExceptionEntity.builder()
                .code(409)
                .description("Already exists")
                .build();
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(EmailExistException.class)
    public ExceptionEntity handleEmailExistException(){
        return ExceptionEntity.builder()
                .code(409)
                .description(" Email already exist")
                .build();
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNameExistException.class)
    public ExceptionEntity handleUserNameExistException(){
        return ExceptionEntity.builder()
                .code(409)
                .description("UserName already exist")
                .build();
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
    public ExceptionEntity handleHttpMessageNotReadableException() {
        return ExceptionEntity.builder()
                .code(400)
                .description("Not valid json format")
                .build();
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public ExceptionEntity handleUserNotFoundException() {
        return ExceptionEntity.builder()
                .code(400)
                .description("user has not registered yet")
                .build();
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(GeneralException.class)
    public ExceptionEntity handleGeneralException(){
        return ExceptionEntity.builder()
                .code(400)
                .description("Something went wrong")
                .build();
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(NoPetException.class)
    public ExceptionEntity handleNoPetException(){
        return ExceptionEntity.builder()
                .code(400)
                .description("user does not have pets")
                .build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PasswordisInCorrect.class)
    public ExceptionEntity handlePasswordIsIncorrect(){
        return ExceptionEntity.builder()
                .code(400)
                .description("Password is incorrect")
                .build();
    }

}
