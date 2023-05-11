package com.microservices.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Exception Controller which contains handler to handle exception.
 */
@ControllerAdvice
public class ExceptionHandler {

   @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionMessage> handleUserException(ResourceNotFoundException exception) {
        String message = exception.getMessage();
        ExceptionMessage exceptionMessage = ExceptionMessage.builder().message(message).errorCode(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ExceptionMessage>(exceptionMessage, HttpStatus.NOT_FOUND);
    }
}
