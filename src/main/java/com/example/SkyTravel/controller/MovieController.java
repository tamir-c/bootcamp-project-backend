package com.example.SkyTravel.controller;

import com.example.SkyTravel.model.Movie;
import com.example.SkyTravel.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable int movieId) {
        return movieService.getMovieById(movieId);
    }


}
