package com.rmnnorbert.VATCalculator.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumericValidator implements ConstraintValidator<Numeric, Double> {
    private String fieldName;

    @Override
    public void initialize(Numeric constraintAnnotation) {
        fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if (value == null || value < 0) {
            context.buildConstraintViolationWithTemplate(fieldName + context.getDefaultConstraintMessageTemplate())
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        }
        return true;
    }
}