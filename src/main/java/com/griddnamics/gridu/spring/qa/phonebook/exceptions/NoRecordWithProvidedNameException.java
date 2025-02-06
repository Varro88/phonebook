package com.griddnamics.gridu.spring.qa.phonebook.exceptions;

public class NoRecordWithProvidedNameException extends RuntimeException {
    public NoRecordWithProvidedNameException(String message) {
        super(message);
    }
}
