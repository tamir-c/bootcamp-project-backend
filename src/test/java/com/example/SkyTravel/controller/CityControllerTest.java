package com.example.SkyTravel.controller;

import com.example.SkyTravel.model.City;
import com.example.SkyTravel.service.CityService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTest {

    @MockBean
    CityService mockedService;

    @Autowired
    MockMvc mockMvc;


    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getAllCitiesTest() throws Exception{

        City c1 = new City();
        c1.setCity_description("This is london");
        c1.setCity_name("London");
        c1.setCity_url("www.london.co.uk");
        c1.setLatitude(1000);
        c1.setLongitude(2000);


        City c2 = new City();
        c2.setCity_description("This is Tokyo");
        c2.setCity_name("Tokyo");
        c2.setCity_url("www.tokyo.co.uk");
        c2.setLatitude(3000);
        c2.setLongitude(2000);

        List<City> citiesList = new ArrayList<>();

        citiesList.add(c1);
        citiesList.add(c2);

        when(mockedService.getAllCities()).thenReturn(citiesList);
        mockMvc.perform(get("/cities"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //assert
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect((jsonPath("$[0].city_name").value("London")))
                .andExpect((jsonPath("$[1].city_name").value("Tokyo")));



    }
    @Test
    public void getCityByIdTest() throws Exception {
        // Arrange

        City c1 = new City();
        c1.setCity_description("This is london");
        c1.setCity_id(1);
        c1.setCity_name("London");
        c1.setCity_url("www.london.co.uk");
        c1.setLatitude(1000);
        c1.setLongitude(2000);

        when(mockedService.getCityById(anyInt())).thenReturn(c1);

        // Act & Assert
        mockMvc.perform(get("/cities/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.city_id").value(1))
                .andExpect(jsonPath("$.city_name").value("London"));
    }
    
}
