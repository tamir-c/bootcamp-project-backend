package com.example.SkyTravel.controller;


import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{genreId}")
    public Genre getGenreById(@PathVariable int genreId) {
        return genreService.getGenreById(genreId);
    }

    @GetMapping("/{name}")
    public List<Genre> getGenreByName(@PathVariable String name){
        return genreService.getGenreByName(name);
    }





}
