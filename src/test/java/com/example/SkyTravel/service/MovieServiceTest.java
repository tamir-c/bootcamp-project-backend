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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
    public void getMovieByIdReturnsMovie(){

        //arrange
        int id = 1;
        Genre genre = new Genre();
        genre.setGenre_id(1);
        genre.setGenre_name("Action");

        Movie movie = new Movie();
        movie.setMovie_name("Movie 1");
        movie.setPoster_url("poster_url");
        movie.setGenre(genre);
        movie.setDuration_minutes(90);
        movie.setDescription("Movie desc");
        movie.setDirector("Uzma");
        movie.setRelease_year("2023");


        Optional<Movie> optMovie = Optional.of(movie);
        when(mockRepo.findById(1)).thenReturn(optMovie);

        //act
        Movie m = movieService.getMovieById(id);

        //assert
        assertEquals("Movie 1", m.getMovie_name());
        verify(mockRepo, times(1)).findById(1);

    }



}
