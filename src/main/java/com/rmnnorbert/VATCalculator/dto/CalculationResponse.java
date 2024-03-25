package com.rmnnorbert.VATCalculator.dto;

public record CalculationResponse (double priceWithoutVat, double valueAddedTax, double priceIncludingTax){
}
