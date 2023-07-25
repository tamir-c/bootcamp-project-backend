package com.example.SkyTravel.service;

import com.example.SkyTravel.model.City;
import com.example.SkyTravel.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepo;

    public List<City> getAllCities() {
        return cityRepo.findAll();
    }

//    public City getCityById(int cityId) {
//        if(cityId > 0){
//            Optional<City> optCity = cityRepo.findById(cityId);
//            return optCity.orElse(new City());
//        }
//        return new City();
//    }




}
