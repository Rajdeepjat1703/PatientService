package com.example.Patient_sevice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
