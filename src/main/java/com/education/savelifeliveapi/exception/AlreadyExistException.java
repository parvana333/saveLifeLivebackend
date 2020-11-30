package com.education.savelifeliveapi.exception;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException() {
        super();
    }
    public AlreadyExistException(String mes){
        super(mes);
    }

}
