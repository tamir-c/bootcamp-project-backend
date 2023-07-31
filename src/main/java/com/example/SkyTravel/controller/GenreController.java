package com.example.SkyTravel.controller;


import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<List<Genre>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable int id) {
        return ResponseEntity.ok(genreService.getGenreById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Genre>> getGenreByName(@PathVariable String name) {
        return ResponseEntity.ok(genreService.getGenreByName(name));
    }

}
