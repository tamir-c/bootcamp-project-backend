package com.example.SkyTravel.service;

import com.example.SkyTravel.exception.InvalidIdException;
import com.example.SkyTravel.exception.NotFoundException;
import com.example.SkyTravel.model.Movie;
import com.example.SkyTravel.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    public List<Movie> getAllMovies() {
        List<Movie> movieList = movieRepo.findAll();
        if(movieList.isEmpty()){
            throw new NotFoundException("Movies Not Found");
        }
        return movieList;
    }

    public Movie getMovieById(int id) {
        if(id > 0){
            Optional<Movie> optionalMovie = movieRepo.findById(id);
            return optionalMovie.orElseThrow(() -> new NotFoundException("Movie Id Not Found"));
        }else{
            throw new InvalidIdException("Movie Id is Invalid");
        }
    }

}
