package com.example.spring01.controller.error;

import com.example.spring01.model.exceptions.NotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ApiError> handleEntityNotFound(NotFoundException ex) {
        return new ResponseEntity<ApiError>(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), new Date()), HttpStatus.NOT_FOUND);
    }
}