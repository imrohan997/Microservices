package com.microservice.hotelservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ExceptionMessage> resourceNotFound(ResourceNotFound resourceNotFound) {
        String message = resourceNotFound.getMessage();
        ExceptionMessage exceptionMessage = ExceptionMessage.builder().message(message).status(String.valueOf(HttpStatus.NOT_FOUND)).build();
        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }
}
