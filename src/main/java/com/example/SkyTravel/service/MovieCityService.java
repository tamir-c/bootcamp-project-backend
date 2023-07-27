package com.example.SkyTravel.service;

import com.example.SkyTravel.exception.InvalidIdException;
import com.example.SkyTravel.exception.NotFoundException;
import com.example.SkyTravel.model.MovieCity;
import com.example.SkyTravel.repository.MovieCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieCityService {

    @Autowired
    private MovieCityRepository movieCityRepo;

    public List<MovieCity> getAllMovieCities() {
        List<MovieCity> movieCityList = movieCityRepo.findAll();
        if(movieCityList.isEmpty()){
            throw new NotFoundException("Not Found");
        }
        return movieCityList;
    }

    public MovieCity getMovieCityById(int movieCityId) {
        if(movieCityId > 0){
            Optional<MovieCity> optionalMovieCity = movieCityRepo.findById(movieCityId);
            return optionalMovieCity.orElseThrow(() -> new NotFoundException("Id Not Found"));
        }else{
            throw new InvalidIdException("MovieCity Id is invalid");
        }
    }



}
