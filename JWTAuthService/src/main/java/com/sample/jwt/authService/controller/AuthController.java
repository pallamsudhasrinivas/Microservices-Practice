package com.sample.jwt.authService.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.sample.jwt.authService.model.Credentials;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.*;

@RestController
public class AuthController {

    public static final String serverUrl = "http://localhost:8081"; //http://userservice

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> getJWTToken(@RequestBody Credentials credentials) throws UnsupportedEncodingException {
        Map<String,String> response = new HashMap<>();
        try {
            // Validate username and password
            boolean isValid = validateCredentials(credentials.getUsername(), credentials.getPassword());
            if(isValid) {
                Algorithm algorithm = Algorithm.HMAC256("secret");
                String token = JWT.create()
                        .withIssuer("sudha")
                        .withSubject(credentials.getUsername())
                        .withClaim("preferred_username", credentials.getUsername())
                        .sign(algorithm);
                response.put("token",token);
                response.put("status","Success");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else{
                response.put("Message","Not a Valid Username");
                response.put("status","Failure");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (UnsupportedEncodingException exception){
            throw exception;
        } catch (JWTCreationException exception){
            throw exception;
        }

    }

    /**
     * Validate the Username and password based on the
     * @param username
     * @param password
     * @return
     */
    private boolean validateCredentials(String username, String password) {

        List<LinkedHashMap<String,String>> userList = (List<LinkedHashMap<String, String>>) new RestTemplate().getForEntity(serverUrl+"/allusers", List.class).getBody();

        List<String> userNameList = new ArrayList<>();
        if(null!=userList) {
            for (LinkedHashMap<String,String>  user : userList) {
                userNameList.add(user.get("username"));
            }
        }
        //check in DB and and return true or false
        if(userNameList.contains(username)) {
            return true;
        }else{
            return false;
        }
    }
}
