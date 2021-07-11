package com.mycode.microservice.currencyexchangeservice.controller;

import com.mycode.microservice.currencyexchangeservice.beans.CurrencyExchange;
import com.mycode.microservice.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment env;

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange convertCurrency(@PathVariable String from, @PathVariable String to){
        //CurrencyExchange convert = new CurrencyExchange(1000L,from,to, BigDecimal.valueOf(50));
        CurrencyExchange convert = repository.findByFromAndTo(from,to);
        String port = env.getProperty("local.server.port");
        convert.setEnvironment(port);
        return convert;
    }


}
