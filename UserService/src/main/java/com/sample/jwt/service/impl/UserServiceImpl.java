package com.sample.jwt.service.impl;

import com.sample.jwt.model.User;
import com.sample.jwt.repo.UserRepository;
import com.sample.jwt.service.AuthService;
import com.sample.jwt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public static final String server = "http://localhost:8083"; //http://messagingapi

    @Autowired
    private UserRepository userRepo;

    @Autowired
    AuthService authService;

    private RestTemplate restTemplate;

    @Override
    public User createUser(User user) {
        User userCreated = userRepo.save(user);
        if(null!=userCreated) {
            // publish email to kakfa
            restTemplate = new RestTemplate();
            HttpStatus status = restTemplate.postForEntity(server+"/publish?message="+user.getEmail(), user.getEmail(), String.class).getStatusCode();
        }

        return userCreated;
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userName, String jwt) throws Exception {

        boolean isValidUser = authService.validateUser(userName,jwt);

        if(isValidUser){
            return userRepo.findByUsername(userName);
        }else{
            throw new Exception("Not a valid user");
        }
    }
}
