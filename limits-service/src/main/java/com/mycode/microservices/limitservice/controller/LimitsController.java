package com.mycode.microservices.limitservice.controller;

import com.mycode.microservices.limitservice.beans.Limits;
import com.mycode.microservices.limitservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration limitsConfig;

    @GetMapping(path="/limits")
    public Limits retrieveLimits(){
        return new Limits(limitsConfig.getMinimum(), limitsConfig.getMaximum());
    }

}
