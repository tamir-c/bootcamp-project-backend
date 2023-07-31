package com.example.SkyTravel.controller;

import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.model.Movie;
import com.example.SkyTravel.model.User;
import com.example.SkyTravel.service.MovieService;
import com.example.SkyTravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User u) {
        User createdU = userService.postUser(u);
        if (createdU == null) {
            return new ResponseEntity<>(new User(), HttpStatus.PRECONDITION_FAILED);
        } else {
            return new ResponseEntity<>(createdU, HttpStatus.CREATED);
        }
    }
}
