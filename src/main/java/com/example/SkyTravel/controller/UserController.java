package com.example.SkyTravel.controller;

import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.model.Movie;
import com.example.SkyTravel.model.User;
import com.example.SkyTravel.service.MovieService;
import com.example.SkyTravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/{user_id}")
    public User getUserById(@PathVariable int user_id) {
        return userService.getUserById(user_id);
    }

}
