package com.example.SkyTravel.service;

import com.example.SkyTravel.model.MovieCity;
import com.example.SkyTravel.repository.MovieCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCityService {

    @Autowired
    private MovieCityRepository movieCityRepo;

    public List<MovieCity> getAllMovieCities() {
        return movieCityRepo.findAll();
    }

    public MovieCity getMovieCityById(int movieCityId) {
        return movieCityRepo.findById(movieCityId).orElse(null);
    }



}
