package com.maktab.final_project.exception;

import java.io.IOException;

public class InvalidImageTypeException extends IOException {
    public InvalidImageTypeException(String message) {
        super(message);
    }

    public InvalidImageTypeException() {
    }
}
