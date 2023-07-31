package com.example.SkyTravel.controller;

import com.example.SkyTravel.model.City;
import com.example.SkyTravel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;


    @GetMapping
    public ResponseEntity<List<City>>  getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());

    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable int id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }








}
