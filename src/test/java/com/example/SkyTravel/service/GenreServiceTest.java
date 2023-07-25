package com.example.SkyTravel.service;


import com.example.SkyTravel.exception.InvalidIdException;
import com.example.SkyTravel.exception.NotFoundException;
import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.repository.GenreRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GenreServiceTest {

    @MockBean
    GenreRepository mockRepo;

    @Autowired
    GenreService genreService;

    @Test
    public void getGenreByIdThrowsExceptionIfNegative(){
        //arrange
        int id = -1;

        //act
        InvalidIdException thrown = Assertions.assertThrows(InvalidIdException.class, () -> {
            genreService.getGenreById(id);
        });

        //assert
        assertEquals("Genre Id is invalid", thrown.getMessage());
    }


    @Test
    public void getGenreByIdThrowsExceptionIfNotFound(){

        //arrange
        int id = 10;

        //act
        Optional<Genre> optGenre = Optional.empty();
        when(mockRepo.findById(id)).thenReturn(optGenre);
        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            genreService.getGenreById(id);
        });

        //assert

        assertEquals("Genre Not Found", thrown.getMessage());
        verify(mockRepo, times(1)).findById(id);
    }

    @Test
    public void getGenreByIdReturnsGenre(){

        //arrange
        int id = 1;
        Genre genre = new Genre();
        genre.setGenre_id(1);
        genre.setGenre_name("Action");

        Optional<Genre> optGenre = Optional.of(genre);
        when(mockRepo.findById(1)).thenReturn(optGenre);

        //act
        Genre g = genreService.getGenreById(id);

        //assert
        assertEquals("Action", g.getGenre_name());
        verify(mockRepo, times(1)).findById(1);

    }
}
