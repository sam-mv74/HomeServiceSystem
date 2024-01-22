package com.maktab.final_project.exception;

public class EntityOperationException extends RuntimeException{
    public EntityOperationException() {
    }

    public EntityOperationException(String message) {
        super(message);
    }

    public EntityOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
