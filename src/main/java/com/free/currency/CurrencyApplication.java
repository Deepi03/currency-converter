package com.free.currency;

import java.io.IOException;

import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.free.currency.quartz.CurrencyScheduler;

@SpringBootApplication
public class CurrencyApplication {

	public static void main(String[] args) throws IOException, SchedulerException {

		// Quartz job to fetch exchange rate in interval
		CurrencyScheduler.triggerCurrencyScheduler();
		SpringApplication.run(CurrencyApplication.class, args);
	}

}
