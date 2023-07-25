package com.example.SkyTravel.controller;


import com.example.SkyTravel.model.MovieCity;
import com.example.SkyTravel.service.MovieCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moviecity")
public class MovieCityController {

    @Autowired
    private MovieCityService movieCityService;

    @GetMapping
    public List<MovieCity> getAllMovieCities() {
        return movieCityService.getAllMovieCities();
    }

    @GetMapping("/{movieCityId}")
    public MovieCity getMovieCityById(@PathVariable int movieCityId) {
        return movieCityService.getMovieCityById(movieCityId);
    }

}
