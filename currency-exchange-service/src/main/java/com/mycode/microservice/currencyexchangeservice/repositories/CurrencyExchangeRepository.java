package com.mycode.microservice.currencyexchangeservice.repositories;

import com.mycode.microservice.currencyexchangeservice.beans.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {

    CurrencyExchange findByFromAndTo(String currency_from, String currency_to);
}
