package com.sample.jwt.service.impl;

import com.auth0.jwt.JWTVerifier;
import com.sample.jwt.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sample.jwt.model.User;

import java.io.UnsupportedEncodingException;

@Service
public class AuthServiceImpl implements AuthService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);


    @Override
    public boolean validateUser(String userName, String jwtToken) {

        String token = jwtToken.substring(jwtToken.lastIndexOf("Bearer ")+7);
        try {
            JWTVerifier verifier = JWT.require(getAlgorithm())
                    .withIssuer("sudha")
                    .build();
            verifier.verify(token);
            DecodedJWT decode = JWT.decode(token);
            String usernameFromToken = decode.getClaim("preferred_username").asString();
            if(!userName.equals(usernameFromToken) && !userName.equals("admin")){
                LOGGER.warn("Token owner and request user are different. Not authorised");
                return false;
            }else{
                return true;
            }
        } catch (UnsupportedEncodingException | SignatureVerificationException | JWTDecodeException | InvalidClaimException e) {
            LOGGER.error("Exception while validating token",e);
            e.printStackTrace();
            return false;
        }

    }

    private Algorithm getAlgorithm() throws UnsupportedEncodingException {
        return Algorithm.HMAC256("secret");
    }
}
