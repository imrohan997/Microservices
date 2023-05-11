package com.microservice.hotelservice.exception;

import lombok.Builder;

@Builder
public class ExceptionMessage {
    String message;
    String status;
}
