package com.griddnamics.gridu.spring.qa.phonebook.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoRecordWithProvidedNameException extends RuntimeException {
    public NoRecordWithProvidedNameException(String message) {
        super(message);
    }
}
