package com.example.SkyTravel.controller;

import com.example.SkyTravel.model.City;
import com.example.SkyTravel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;


    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }



//    @GetMapping("/{cityId}")
//    public City getCityById(@PathVariable int cityId) {
//        return cityService.getCityById(cityId);
//    }








}
