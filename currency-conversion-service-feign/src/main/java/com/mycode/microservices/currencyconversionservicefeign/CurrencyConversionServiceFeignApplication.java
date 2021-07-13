package com.mycode.microservices.currencyconversionservicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionServiceFeignApplication.class, args);
    }

}
