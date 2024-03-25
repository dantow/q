package com.rmnnorbert.VATCalculator.dto;

import com.rmnnorbert.VATCalculator.validator.Numeric;
import com.rmnnorbert.VATCalculator.validator.Tax;
import jakarta.validation.constraints.Min;

public record CalculationRequest(@Numeric(fieldName = "Net value")
                                 double netValue,
                                 @Numeric(fieldName = "Tax value")
                                 double taxValue,
                                 @Numeric(fieldName = "Gross value")
                                 double grossValue,
                                 @Tax
                                         @Min(1)
                                 double vatRate) {
}
