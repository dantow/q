package com.rmnnorbert.VATCalculator.controller;

import com.rmnnorbert.VATCalculator.dto.VatRateListResponse;
import com.rmnnorbert.VATCalculator.service.VatRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vat")
public class VatRateController {
    private final VatRateService vatRateService;
    @Autowired
    public VatRateController(VatRateService vatRateService) {
        this.vatRateService = vatRateService;
    }

    @GetMapping("/")
    public ResponseEntity<VatRateListResponse> getVatRates() {
        return ResponseEntity.ok(vatRateService.getVatRates());
    }
}
