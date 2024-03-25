package com.rmnnorbert.VATCalculator.service;

import com.rmnnorbert.VATCalculator.dto.CalculationRequest;
import com.rmnnorbert.VATCalculator.dto.CalculationResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationServiceTest {
    private CalculationService calculationService;

    @BeforeEach
    void setUp() {
        calculationService = new CalculationService();
    }

    @AfterEach
    void tearDown() {
        calculationService = null;
    }

    @ParameterizedTest
    @MethodSource("calculationRequestProviderAndPriceIncludingTax")
    void calculateAmounts(CalculationRequest request, int result) {
        CalculationResponse actual = calculationService.calculateAmounts(request);
        assertEquals(result, actual.priceIncludingTax());
    }

    private static Stream<Arguments> calculationRequestProviderAndPriceIncludingTax() {
        return Stream.of(
                Arguments.of(new CalculationRequest(100,0,0,10),
                        110),
                Arguments.of(new CalculationRequest(0,100,0,10),
                        1100),
                Arguments.of(new CalculationRequest(0,0,110,10),
                        110)
        );
    }
}