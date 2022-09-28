package com.free.currency.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.free.currency.dto.CurrencyExchangeRateRequest;

public class GetExchangeRateServiceTest {

    String eur = "EUR";
    String usd = "USD";
    String inr = "INR";

    GetExchangeRateService getExchangeRateService = new GetExchangeRateService();

    @Test
    public void getCurrencyRateTest() {
        assertEquals(0.96, getExchangeRateService.getCurrencyRate(new CurrencyExchangeRateRequest(eur, usd, "1")));
    }

}
