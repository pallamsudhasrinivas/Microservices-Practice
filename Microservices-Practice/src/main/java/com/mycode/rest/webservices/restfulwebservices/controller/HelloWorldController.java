package com.mycode.rest.webservices.restfulwebservices.controller;


import com.mycode.rest.webservices.restfulwebservices.beans.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path="/hello-world/{name}")
    public String helloWorldSudha(@PathVariable String name){
        return "Hello "+name+", welcome to world of REST services!!";
    }

    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Sudha");
    }
}
