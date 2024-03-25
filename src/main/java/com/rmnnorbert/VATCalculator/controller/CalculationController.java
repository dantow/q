package com.rmnnorbert.VATCalculator.controller;

import com.rmnnorbert.VATCalculator.dto.CalculationRequest;
import com.rmnnorbert.VATCalculator.dto.CalculationResponse;
import com.rmnnorbert.VATCalculator.service.CalculationService;
import com.rmnnorbert.VATCalculator.service.ValidationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculationController {
    private final CalculationService calculationService;
    private final ValidationService validationService;
    @Autowired
    public CalculationController(CalculationService calculationService, ValidationService validationService) {
        this.calculationService = calculationService;
        this.validationService = validationService;
    }

    @PostMapping("/amounts")
    public ResponseEntity<CalculationResponse> calculateAmounts(@RequestBody @Valid CalculationRequest request) {
        validationService.validateRequest(request);
        return ResponseEntity.ok(calculationService.calculateAmounts(request));
    }

}
