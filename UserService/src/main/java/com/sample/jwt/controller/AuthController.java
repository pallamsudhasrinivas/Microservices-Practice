package com.sample.jwt.controller;

import com.sample.jwt.model.Credentials;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AuthController {

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String authenticateUser(String username, String password) {

        String token  = new RestTemplate().postForEntity("http://localhost:8080/auth",new Credentials(username,password),String.class).getBody();

        return token;
    }
}
