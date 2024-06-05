package com.example.demo.controller.Advice;

import com.example.demo.exception.InvalidInputException;
import com.example.demo.model.ErrorData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorAdviceController {

    @ExceptionHandler(value
            = { InvalidInputException.class })
    public ResponseEntity<ErrorData> handleConflict(
            InvalidInputException ex, WebRequest request) {
        ErrorData errorData = new ErrorData(ex.getMessage(),HttpStatus.BAD_REQUEST.name(),ex.getClass().getName());
        return new ResponseEntity<>(errorData,HttpStatus.BAD_REQUEST);
    }

}
