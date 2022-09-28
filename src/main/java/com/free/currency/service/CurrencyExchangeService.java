package com.free.currency.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.free.currency.dto.CurrencyExchangeApiResponse;
import com.free.currency.dto.CurrencyInput;

public class CurrencyExchangeService {

        String API_KEY = "ppsxvS7KDPtZ7qcQyqM5NPvyqBD4tVmK";

        private final OkHttpClient httpClient = new OkHttpClient();

        public double getCurrencyRate(CurrencyInput currencyInput) throws IOException {

                Request request = new Request.Builder()
                                .url("https://api.apilayer.com/exchangerates_data/convert?to="
                                                + currencyInput.getFrom()
                                                + "&from=" + currencyInput.getTo() + "&amount="
                                                + currencyInput.getAmount())
                                .addHeader("apikey", API_KEY) // add request headers
                                .method("GET", null)
                                .build();
                Response response = httpClient.newCall(request).execute();
                ObjectMapper m = new ObjectMapper();
                CurrencyExchangeApiResponse exchangeResponse = m.readValue(response.body().string(),
                                new TypeReference<CurrencyExchangeApiResponse>() {
                                });

                System.out.println(" ????????? " +
                                exchangeResponse.getResult());

                return exchangeResponse.getResult();
        }
}
