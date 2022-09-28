package com.free.currency.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.free.currency.dto.CurrencyExchangeApiResponse;
import com.free.currency.dto.CurrencyExchangeRateRequest;

public class CurrencyExchangeService {

        String API_KEY = "GB4yze8GY0JGLlDYw08p4d1cJXQpxLKY";

        private final OkHttpClient httpClient = new OkHttpClient();

        public double getCurrencyRate(CurrencyExchangeRateRequest currencyExchangeRateRequest) throws IOException {

                Request request = new Request.Builder()
                                .url("https://api.apilayer.com/exchangerates_data/convert?to="
                                                + currencyExchangeRateRequest.getFrom()
                                                + "&from=" + currencyExchangeRateRequest.getTo() + "&amount="
                                                + currencyExchangeRateRequest.getAmount())
                                .addHeader("apikey", API_KEY) // add request headers
                                .method("GET", null)
                                .build();
                Response response = httpClient.newCall(request).execute();
                ObjectMapper m = new ObjectMapper();
                CurrencyExchangeApiResponse exchangeResponse = m.readValue(response.body().string(),
                                new TypeReference<CurrencyExchangeApiResponse>() {
                                });
                return exchangeResponse.getResult();
        }
}
