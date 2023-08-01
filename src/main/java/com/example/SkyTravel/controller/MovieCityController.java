package com.example.SkyTravel.controller;


import com.example.SkyTravel.model.City;
import com.example.SkyTravel.model.MovieCity;
import com.example.SkyTravel.service.MovieCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/moviecity")
public class MovieCityController {

    @Autowired
    private MovieCityService movieCityService;

    @GetMapping
    public ResponseEntity<List<MovieCity>> getAllMovieCities() {
        return ResponseEntity.ok(movieCityService.getAllMovieCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<City>> getMovieCityById(@PathVariable int id) {
        return ResponseEntity.ok(movieCityService.getMovieCitiesById(id));
    }

}
