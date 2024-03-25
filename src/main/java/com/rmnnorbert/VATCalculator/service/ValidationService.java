package com.rmnnorbert.VATCalculator.service;

import com.rmnnorbert.VATCalculator.dto.CalculationRequest;
import com.rmnnorbert.VATCalculator.exception.InvalidNumericInputException;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    public void validateRequest(CalculationRequest request) {
        int count = 0;
        if (request.netValue() > 0) count++;
        if (request.taxValue() > 0) count++;
        if (request.grossValue() > 0) count++;

        if (count != 1) {
            throw new InvalidNumericInputException();
        }
    }
}
