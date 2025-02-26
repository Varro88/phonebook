package com.griddnamics.gridu.spring.qa.phonebook.controller.exception;

public class RecordAlreadyExistsException extends RuntimeException {
    public RecordAlreadyExistsException(String message) {
        super(message);
    }
}
