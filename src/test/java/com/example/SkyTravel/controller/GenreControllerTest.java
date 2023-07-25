package com.example.SkyTravel.controller;

import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.service.GenreService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class GenreControllerTest {

    @MockBean
    GenreService mockedService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getAllGenresTest() throws Exception{
        //arrange
        Genre g = new Genre();
        g.setGenre_name("Action");

        Genre g2 = new Genre();
        g2.setGenre_name("Romance");

        List<Genre> genres = new ArrayList<>();
        genres.add(g);
        genres.add(g2);

        when(mockedService.getAllGenres()).thenReturn(genres);

        //act
        mockMvc.perform(get("/genres"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //assert
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].genre_name").value("Action"))
                .andExpect(jsonPath("$[1].genre_name").value("Romance"));
    }
}
