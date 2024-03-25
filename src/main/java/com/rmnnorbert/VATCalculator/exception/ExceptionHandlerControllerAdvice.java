package com.rmnnorbert.VATCalculator.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(InvalidNumericInputException.class)
    public ResponseEntity<String> handleInvalidNumericException(InvalidNumericInputException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
   @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(exception.getFieldErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        //System.out.println(exception.getClass().getSimpleName() + " :" + exception.getMessage());
        String causeMessage = exception.getCause().getMessage();
        System.out.println(causeMessage);
        String errorMessage = "Invalid input value. Please provide a valid numeric value.";
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
