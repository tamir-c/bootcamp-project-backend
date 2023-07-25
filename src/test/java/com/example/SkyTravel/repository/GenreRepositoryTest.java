package com.example.SkyTravel.repository;


import com.example.SkyTravel.model.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@DataJpaTest
@PropertySource("test-app.properties")
public class GenreRepositoryTest {


    @Autowired
    GenreRepository genreRepository;

    @Test
    public void TestFindGenreByName(){
        //arrange
        Genre g = new Genre();
        g.setGenre_name("Action");

        genreRepository.save(g);

        Genre g2 = new Genre();
        g2.setGenre_name("Romance");

        genreRepository.save(g2);

        //act
        List<Genre> genre = genreRepository.findByGenreName("Action%");
        

        //assert
        assertEquals(1, genre.size());
        assertEquals("Action", genre.get(0).getGenre_name());
    }
}
