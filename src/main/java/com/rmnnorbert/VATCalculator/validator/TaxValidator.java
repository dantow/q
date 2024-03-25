package com.rmnnorbert.VATCalculator.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TaxValidator implements ConstraintValidator<Tax, Double> {
    @Override
    public void initialize(Tax constraintAnnotation) {
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value != null && value > 0;
    }

}
