package com.example.SkyTravel.service;

import com.example.SkyTravel.exception.NotFoundException;
import com.example.SkyTravel.model.City;

import com.example.SkyTravel.repository.CityRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CityServiceTest {

    @MockBean
    CityRepository mockRepo;


    @Autowired
    CityService cityService;

    @Test
    public void getAllCitiesThrowExceptionIfNoCities(){
        List<City> newCityList = new ArrayList<>();
        when(mockRepo.findAll()).thenReturn(newCityList);
        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            cityService.getAllCities();
        });

        assertEquals("Cities Not Found", thrown.getMessage());
        verify(mockRepo, times(1)).findAll();

    }

    @Test
    public void getCityByIdReturnsCityTest(){

        //arrange
        City c1 = new City();
        c1.setCity_description("This is london");
        c1.setCity_name("London");
        c1.setCity_url("www.london.co.uk");
        c1.setLatitude(1000);
        c1.setLongitude(2000);

        Optional<City> optCity = Optional.of(c1);
        when(mockRepo.findById(1)).thenReturn(optCity);

        //act
        City city = cityService.getCityById(1);

        //assert
        assertEquals("London", city.getCity_name());
        verify(mockRepo, times(1)).findById(1);

    }



}
