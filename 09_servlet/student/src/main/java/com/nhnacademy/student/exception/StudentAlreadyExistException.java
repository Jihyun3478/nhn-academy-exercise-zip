package com.nhnacademy.student.exception;

public class StudentAlreadyExistException extends RuntimeException {
    public StudentAlreadyExistException(String message) {
        super(message);
    }
}
