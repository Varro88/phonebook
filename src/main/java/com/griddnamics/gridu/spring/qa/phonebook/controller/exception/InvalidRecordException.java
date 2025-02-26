package com.griddnamics.gridu.spring.qa.phonebook.controller.exception;

public class InvalidRecordException extends RuntimeException {
    public InvalidRecordException(String message) {
        super(message);
    }
}
