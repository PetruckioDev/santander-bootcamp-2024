package com.petruckiodev.santander_bootcamp_2024.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException exception) {
        var error = new ErrorResponse(400, exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatusCode.valueOf(error.status()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException exception) {
        var error = new ErrorResponse(422, exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatusCode.valueOf(error.status()));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedException(Throwable throwable) {
        var message = "Unexpected server error, see logs.";
        logger.error(message, throwable);
        var error = new ErrorResponse(500, message, LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatusCode.valueOf(error.status()));
    }
}
