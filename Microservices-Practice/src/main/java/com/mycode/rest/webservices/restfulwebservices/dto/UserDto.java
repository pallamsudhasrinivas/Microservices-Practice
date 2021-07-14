package com.mycode.rest.webservices.restfulwebservices.dto;

import com.mycode.rest.webservices.restfulwebservices.beans.User;
import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDto {


    List<User> userList = new ArrayList<User>();

    static createUser(){

        userList.add(new User(1,"Sudha", new Date("20 June 1985")));
    }


}
