package com.example.SkyTravel.service;

import com.example.SkyTravel.exception.InvalidIdException;
import com.example.SkyTravel.exception.NotFoundException;
import com.example.SkyTravel.model.City;
import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.repository.CityRepository;
import org.aspectj.weaver.ast.Not;
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
        List<City> cityList = cityRepo.findAll();
        if(cityList.isEmpty()){
            throw new NotFoundException("Not Found");
        }
        return cityList;
    }

    public City getCityById(int cityId) {
        if(cityId > 0){
            Optional<City> optCity = cityRepo.findById(cityId);
            return optCity.orElseThrow(() -> new NotFoundException("City Not Found"));
        }else{
            throw new InvalidIdException("City Id is invalid");
        }
    }





}
