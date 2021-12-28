package com.sample.jwt.service;

import com.sample.jwt.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getUsers();
    User getUser(String userName, String jwtToken) throws Exception;
}
