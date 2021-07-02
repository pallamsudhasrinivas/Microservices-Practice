package com.mycode.rest.webservices.restfulwebservices.controller;

import com.mycode.rest.webservices.restfulwebservices.beans.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @PostMapping(path="/addUser")
    public User addUser(User user){

        return user;
    }

    @GetMapping(path="/getUsers")
    public List<User> getUser(){


        return userList;
    }
}
