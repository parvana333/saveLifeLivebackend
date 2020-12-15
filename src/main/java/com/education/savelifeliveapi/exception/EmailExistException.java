package com.education.savelifeliveapi.exception;

public class EmailExistException extends RuntimeException {

    public EmailExistException(String mes){
        super(mes);
    }
}
