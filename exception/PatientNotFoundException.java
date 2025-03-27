package com.example.Patient_sevice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
}
