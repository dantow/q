package com.rmnnorbert.VATCalculator.service;

import com.rmnnorbert.VATCalculator.dto.CalculationRequest;
import com.rmnnorbert.VATCalculator.dto.CalculationResponse;
import com.rmnnorbert.VATCalculator.exception.InvalidNumericInputException;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    public CalculationResponse calculateAmounts(CalculationRequest request) {
        if (request.netValue() > 0) {
            double tax = calculateAddedTaxFromNet(request.netValue(), request.vatRate());
            double gross = request.netValue() + tax;
            return new CalculationResponse(request.netValue(), tax, gross);
        } else if (request.taxValue() > 0) {
            double net = calculateNetFromTax(request.taxValue(), request.vatRate());
            double gross = net + request.taxValue();
            return new CalculationResponse(net, request.taxValue(), gross);
        } else if (request.grossValue() > 0) {
            double tax = calculateAddedTaxFromGross(request.grossValue(), request.vatRate());
            double net = request.grossValue() - tax;
            return new CalculationResponse(net, tax, request.grossValue());
        }
        throw new InvalidNumericInputException();
    }

    private double calculateNetFromTax(double tax, double VAT) {
        return tax / (VAT / 100);
    }
    private double calculateAddedTaxFromNet(double net, double VAT) {
        return net * (VAT / 100);
    }
    private double calculateAddedTaxFromGross(double gross, double VAT) {
        return gross * (VAT / 100);
    }
}
