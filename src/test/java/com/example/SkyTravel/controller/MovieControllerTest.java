package com.example.SkyTravel.controller;

import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.model.Movie;

import com.example.SkyTravel.service.MovieService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {

    @MockBean
    MovieService mockedService;

    @Autowired
    MockMvc mockMvc;


    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getAllMoviesTest() throws Exception{
        //arrange
        Genre g1 = new Genre();
        g1.setGenre_name("Action");

        Genre g2 = new Genre();
        g2.setGenre_name("Romance");

        Movie movie = new Movie();
        movie.setMovie_name("Movie 1");
        movie.setPoster_url("poster_url");
        movie.setGenre(g1);
        movie.setDuration_minutes(90);
        movie.setDescription("Movie desc");
        movie.setDirector("Uzma");
        movie.setRelease_year("2023");

        Movie movie2 = new Movie();

        movie2.setMovie_name("Movie 2");
        movie2.setPoster_url("poster_url");
        movie2.setGenre(g2);
        movie2.setDuration_minutes(120);
        movie2.setDescription("Movie desc");
        movie2.setDirector("Belinda");
        movie2.setRelease_year("2023");

        List<Movie> movies = new ArrayList<>();

        movies.add(movie);
        movies.add(movie2);

        when(mockedService.getAllMovies()).thenReturn(movies);
        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //assert
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect((jsonPath("$[0].movie_name").value("Movie 1")))
                .andExpect((jsonPath("$[1].movie_name").value("Movie 2")))

        ;





    }
}
