package com.microservices.userservice.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class ExceptionMessage {
    String message;
    HttpStatus errorCode;
}
