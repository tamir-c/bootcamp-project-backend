package com.example.SkyTravel.repository;

import com.example.SkyTravel.model.City;
import com.example.SkyTravel.model.Genre;
import com.example.SkyTravel.model.Movie;
import com.example.SkyTravel.model.MovieCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieCityRepository extends JpaRepository<MovieCity, Integer> {


}
