package com.free.currency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchangeApiResponse {
    private boolean success;
    private Query query;
    private Info info;
    private String date;
    private double result;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Query {
    private String from;
    private String to;
    private int amount;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Info {
    private int timestamp;
    private double rate;
}
