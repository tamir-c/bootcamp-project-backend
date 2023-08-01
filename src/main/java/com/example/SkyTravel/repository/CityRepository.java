package com.example.SkyTravel.repository;

import com.example.SkyTravel.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    @Query(nativeQuery = true, value="select * from city where city_id in (select city_id from movie_city where movie_id = :id)")
    List<City> findCitiesByMovieId(int id);
}


