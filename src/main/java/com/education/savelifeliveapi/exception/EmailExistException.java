package com.education.savelifeliveapi.exception;

public class EmailExistException extends RuntimeException {
    public EmailExistException() {
        super();
    }
    public EmailExistException(String mes){
        super(mes);
    }
}
