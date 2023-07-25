package com.example.SkyTravel.service;

import com.example.SkyTravel.model.Movie;
import com.example.SkyTravel.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    public Movie getMovieById(int movieId) {
        return movieRepo.findById(movieId).orElse(null);
    }

}
