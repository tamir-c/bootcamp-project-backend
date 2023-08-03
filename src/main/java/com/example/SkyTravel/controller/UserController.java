package com.example.SkyTravel.controller;

import com.example.SkyTravel.model.User;
import com.example.SkyTravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<User> postUser(@RequestBody User u) {
        System.out.println(u);
        User createdU = userService.postUser(u);
        if (createdU == null) {
            return new ResponseEntity<>(new User(), HttpStatus.PRECONDITION_FAILED);
        } else {
            return new ResponseEntity<>(createdU, HttpStatus.CREATED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        // Authenticate the user
        if (userService.authenticate(user.getEmail(), user.getPassword())) {
            user.setDisplay_name(userService.userName(user.getEmail()));
            user.setPassword("");
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
        }
    }
}
