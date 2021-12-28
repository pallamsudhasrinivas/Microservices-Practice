package com.sample.jwt.service;

public interface AuthService {
    boolean validateUser(String userName, String jwtToken);
}
