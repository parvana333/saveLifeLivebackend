package com.education.savelifeliveapi.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String mes) {
        super((mes));
    }
}
