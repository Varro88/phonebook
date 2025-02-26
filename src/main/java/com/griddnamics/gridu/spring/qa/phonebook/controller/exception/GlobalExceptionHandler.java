package com.griddnamics.gridu.spring.qa.phonebook.controller.exception;

import com.griddnamics.gridu.spring.qa.phonebook.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleRecordAlreadyExists(RecordAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.name(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoRecordWithProvidedNameException.class)
    public ResponseEntity<ErrorResponse> handleNoRecordWithProvidedName(NoRecordWithProvidedNameException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.name(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRecordException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRecord(InvalidRecordException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.name(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}



