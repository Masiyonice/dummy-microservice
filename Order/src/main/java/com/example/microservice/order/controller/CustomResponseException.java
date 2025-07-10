package com.example.microservice.order.controller;

import com.example.microservice.order.utils.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class CustomResponseException {

    @ExceptionHandler({ResponseStatusException.class})
    public ResponseEntity<CommonResponse<?>> responseResponseStatusException(ResponseStatusException exception){
        CommonResponse<?> response = CommonResponse.builder()
                .statusCode(exception.getStatusCode().value())
                .message(exception.getReason())
                .build();
        return ResponseEntity
                .status(exception.getStatusCode())
                .body(response);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<CommonResponse<?>> responseIllegalArgumentException(IllegalArgumentException exception){
        CommonResponse<?> response = CommonResponse.builder()
                .statusCode(400)
                .message(exception.getMessage())
                .build();
        return ResponseEntity
                .badRequest()
                .body(response);
    }
}
