package com.rmnnorbert.VATCalculator.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NumericValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Numeric {
    String fieldName() default "";
    String message() default  " must be a numeric value, greater or equal than 0.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}