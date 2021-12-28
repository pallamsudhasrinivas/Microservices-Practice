package com.sample.jwt.controller;

import com.sample.jwt.model.User;
import com.sample.jwt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getUserDetails(@RequestParam String username, @RequestHeader(value="Authorization") String jwt) throws Exception {
        logger.info("Get User Called");
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jwt);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        try {
            return new ResponseEntity<>(userService.getUser(username, jwt),HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity("Not a valid User",HttpStatus.FORBIDDEN);
        }
        //return new RestTemplate().exchange("http://localhost:8082/user/"+username, HttpMethod.GET, entity, User.class).getBody();
    }



    @PostMapping(value = "/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        //TODO: call service and save to h2 db and then call messaging service to sent out the mail
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser,HttpStatus.OK);
    }

    @GetMapping(value="/allusers")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }
}
