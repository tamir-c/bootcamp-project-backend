package com.example.SkyTravel.service;

import com.example.SkyTravel.exception.NotFoundException;
import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.model.Movie;
import com.example.SkyTravel.repository.GenreRepository;
import com.example.SkyTravel.repository.MovieRepository;
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
public class MovieServiceTest {

    @MockBean
    MovieRepository mockRepo;

    @Autowired
    MovieService movieService;

    @Test
    public void getAllMoviesThrowsExceptionIfNoMovies(){
        List<Movie> newL = new ArrayList<Movie>();
        when(mockRepo.findAll()).thenReturn(newL);
        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            movieService.getAllMovies();
        });

        assertEquals("Movies Not Found", thrown.getMessage());
        verify(mockRepo, times(1)).findAll();



    }


    @Test
    public void getAllMoviesDoesNotThrowException(){
//        Genre genre = new Genre();
//        genre.setGenre_id(1);
//        genre.setGenre_name("Action");
//
//        int id = 12;
//        Movie movie = new Movie();
//        movie.setMovie_name("Movie 1");
//
//        movie.setDescription("Movie Description");
//
//        movie.setDirector("Uzma");
//        movie.setGenre(genre);
//
//        movie.setDuration_minutes(50);
//
//        movie.setRelease_year("2020");
//
//        movie.setPoster_url("url");
//
//        List<Movie> m = movieService.getAllMovies();









    }


}
