package com.example.SkyTravel.repository;

import com.example.SkyTravel.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    @Query(nativeQuery = true, value="select * from genre where genre_name like :name")
    List<Genre> findByGenreName(String name);


}
