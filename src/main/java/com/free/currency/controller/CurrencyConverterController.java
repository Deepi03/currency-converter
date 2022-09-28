package com.free.currency.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.free.currency.dto.CurrencyExchangeRateRequest;
import com.free.currency.dto.ExchangeResponse;
import com.free.currency.service.GetExchangeRateService;

@Controller
public class CurrencyConverterController {

        GetExchangeRateService getExchangeRateService = new GetExchangeRateService();

        @GetMapping("/exchange_amount")
        public ResponseEntity<ExchangeResponse> exchangeCurrency(
                        @RequestBody CurrencyExchangeRateRequest currencyExchangeRateRequest)
                        throws IOException {
                System.out.println("currency controller ####" + currencyExchangeRateRequest.getFrom());
                Double rate = getExchangeRateService.getCurrencyRate(currencyExchangeRateRequest);
                ExchangeResponse resp = new ExchangeResponse();
                resp.setFrom(currencyExchangeRateRequest.getFrom());
                resp.setTo(currencyExchangeRateRequest.getTo());
                resp.setAmount(Double.parseDouble(currencyExchangeRateRequest.getAmount()) * rate);
                resp.setRate(rate);
                return ResponseEntity.ok(resp);
        }
}
