package com.rmnnorbert.VATCalculator.service;

import com.rmnnorbert.VATCalculator.dto.CalculationRequest;
import com.rmnnorbert.VATCalculator.exception.InvalidNumericInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceTest {
    private ValidationService validationService;

    @BeforeEach
    void setUp() {
        validationService = new ValidationService();
    }
    @AfterEach
    void tearDown() {
        validationService = null;
    }
    @Test
    void validateRequestWithInValidNumericInputShouldThrowInvalidNumericInputException() {
        CalculationRequest request = new CalculationRequest(1,1,0,1);

        assertThrows(InvalidNumericInputException.class, () ->validationService.validateRequest(request));
    }

}