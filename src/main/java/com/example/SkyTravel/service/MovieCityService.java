package com.example.SkyTravel.service;

import com.example.SkyTravel.exception.InvalidIdException;
import com.example.SkyTravel.exception.NotFoundException;
import com.example.SkyTravel.model.City;
import com.example.SkyTravel.model.MovieCity;
import com.example.SkyTravel.repository.CityRepository;
import com.example.SkyTravel.repository.MovieCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieCityService {

    @Autowired
    private MovieCityRepository movieCityRepo;

    @Autowired
    private CityRepository cityRepo;

    public List<MovieCity> getAllMovieCities() {
        List<MovieCity> movieCityList = movieCityRepo.findAll();
        if(movieCityList.isEmpty()){
            throw new NotFoundException("Not Found");
        }
        return movieCityList;
    }

    public List<City> getMovieCitiesById(int id) {
        if(id > 0){
            List<City> optionalMovieCities = cityRepo.findCitiesByMovieId(id);
            if (optionalMovieCities.size() == 0) {
                throw new NotFoundException("Id Not Found");
            }
            else {
                return optionalMovieCities;
            }
        }else{
            throw new InvalidIdException("MovieCity Id is invalid");
        }
    }



}
