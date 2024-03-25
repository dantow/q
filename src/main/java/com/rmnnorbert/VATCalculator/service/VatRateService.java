package com.rmnnorbert.VATCalculator.service;

import com.rmnnorbert.VATCalculator.dto.VatRateListResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VatRateService {
    public VatRateListResponse getVatRates() {
        return new VatRateListResponse(new ArrayList<>(List.of(10, 13, 20)));
    }
}
