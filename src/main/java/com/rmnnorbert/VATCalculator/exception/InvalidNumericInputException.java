package com.rmnnorbert.VATCalculator.exception;

public class InvalidNumericInputException extends RuntimeException {
    public InvalidNumericInputException() {
        super("At least one from  net, tax or gross value must be greater than 0 for calculation.");
    }
}
