package com.example.ticket.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    private static final String REQUEST_VALIDATION_ERRORS
            = "Request validation errors";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage>
    handleValidationExceptions(MethodArgumentNotValidException ex) {

        ErrorMessage errorMessage=new ErrorMessage();
        List<String> details = new ArrayList<String>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
       errorMessage.setError(details);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
