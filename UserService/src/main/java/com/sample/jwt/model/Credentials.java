package com.sample.jwt.model;

public class Credentials {

    String username;

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String password;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
