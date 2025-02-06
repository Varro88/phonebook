package com.griddnamics.gridu.spring.qa.phonebook.exceptions;

public class InvalidRecordException extends RuntimeException {
    public InvalidRecordException(String message) {
        super(message);
    }
}
