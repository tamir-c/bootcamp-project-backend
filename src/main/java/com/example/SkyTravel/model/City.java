package com.example.SkyTravel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;

    @NonNull
    private String city_name;


    private double longitude;

    private double latitude;

    // One city can be associated with multiple movie_city entries
    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<MovieCity> movieCities;



}
