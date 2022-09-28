package com.free.currency.service;

import static com.free.currency.quartz.CurrencyConversionJob.ExchangeRateMap;

import java.util.Arrays;
import java.util.List;

import com.free.currency.dto.CurrencyExchangeRateRequest;
import com.free.currency.exception.InvalidInputException;

public class GetExchangeRateService {

    String fromCurrency;
    String toCurrency;

    public boolean isValidInput(String from, String to, String amount) {
        List<String> allowedCurrencies = Arrays.asList("EUR", "USD", "SEK");
        this.fromCurrency = from.toUpperCase();
        this.toCurrency = to.toUpperCase();
        Double amountDouble = Double.parseDouble(amount);
        if (!fromCurrency.equals(
                toCurrency) && allowedCurrencies.contains(
                        fromCurrency)
                && allowedCurrencies.contains(toCurrency) && amountDouble > 0) {
            return true;
        }
        throw new InvalidInputException();
    }

    public Double getCurrencyRate(CurrencyExchangeRateRequest exchangeRequest) {
        isValidInput(exchangeRequest.getFrom(), exchangeRequest.getTo(), exchangeRequest.getAmount());
        return ExchangeRateMap.get(fromCurrency + "-" + toCurrency);

    }
}
