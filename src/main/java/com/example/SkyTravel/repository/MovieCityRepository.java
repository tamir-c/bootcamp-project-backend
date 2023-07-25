package com.example.SkyTravel.repository;

import com.example.SkyTravel.model.MovieCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCityRepository extends JpaRepository<MovieCity, Integer> {
}
