package com.example.SkyTravel.service;

import com.example.SkyTravel.exception.InvalidIdException;
import com.example.SkyTravel.exception.NotFoundException;
import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepo;

    public List<Genre> getAllGenres() {
        List<Genre> genreList = genreRepo.findAll();
        if (genreList.isEmpty()) {
            throw new NotFoundException("Genre Not Found");
        }
        return genreList;
    }

    public Genre getGenreById(int genreId) {
        if(genreId > 0){
            Optional<Genre> optionalGenre = genreRepo.findById(genreId);
            return optionalGenre.orElseThrow(() -> new NotFoundException("Genre Not Found"));
        }else{
            throw new InvalidIdException("Genre Id is invalid");
        }
    }

    public List<Genre> getGenreByName(String name){
        List<Genre> genreList = genreRepo.findByGenreName(name);
        if(genreList.isEmpty()){
            throw new NotFoundException("Genre Not Found");
        }
        return genreList;

    }

//    public Genre saveGenre(Genre genre) {
//        return genreRepo.save(genre);
//    }

//    public Genre updateGenre(int genreId, Genre updatedGenre) {
//        Genre existingGenre = genreRepo.findById(genreId).orElse(null);
//        if (existingGenre != null) {
//            existingGenre.setGenre_name(updatedGenre.getGenre_name());
//            return genreRepo.save(existingGenre);
//        }
//        return null;
//    }

//    public void deleteGenre(int genreId) {
//        if(genreId > 0){
//            genreRepo.deleteById(genreId);
//        }
//    }
}
