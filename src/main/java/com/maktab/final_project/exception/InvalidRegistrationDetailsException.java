package com.maktab.final_project.exception;

public class InvalidRegistrationDetailsException extends RuntimeException{
    public InvalidRegistrationDetailsException(String message) {
        super(message);
    }

    public InvalidRegistrationDetailsException() {
    }
}