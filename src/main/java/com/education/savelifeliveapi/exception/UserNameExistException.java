package com.education.savelifeliveapi.exception;

public class UserNameExistException extends RuntimeException {
    public UserNameExistException() {
        super();
    }
    public UserNameExistException(String mes){
        super(mes);
    }
}
