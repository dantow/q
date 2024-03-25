package com.rmnnorbert.VATCalculator.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TaxValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Tax {
    String message() default "Tax must be a numeric value, greater than 0.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}