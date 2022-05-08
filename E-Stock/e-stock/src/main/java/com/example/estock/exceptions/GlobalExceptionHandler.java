package com.example.estock.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.estock.model.exception.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EStockNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handler(EStockNotFoundException ex) {
        ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value());
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
                HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ExceptionResponse> handler(InvalidDataException ex) {
        ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value());
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
                HttpStatus.BAD_REQUEST);
        return response;
    }

}
