package com.free.currency.quartz;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.free.currency.dto.CurrencyExchangeRateRequest;
import com.free.currency.service.CurrencyExchangeService;

public class CurrencyConversionJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            fetchExchangeRateForGivenCurrency();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Double> ExchangeRateMap = new HashMap<>();

    private static void fetchExchangeRateForGivenCurrency() throws IOException {
        List<String> currencies = Arrays.asList("EUR-SEK", "SEK-USD", "USD-EUR", "EUR-USD", "USD-SEK", "SEK-EUR");
        CurrencyExchangeService currencyExchangeService = new CurrencyExchangeService();

        for (String fromToCurrency : currencies) {
            String fromCurrency = fromToCurrency.split("-")[0];
            String toCurrency = fromToCurrency.split("-")[1];
            CurrencyExchangeRateRequest currencyExchangeRateRequest = new CurrencyExchangeRateRequest(fromCurrency,
                    toCurrency, "1");
            ExchangeRateMap.put(fromToCurrency, currencyExchangeService.getCurrencyRate(currencyExchangeRateRequest));
        }

    }

}