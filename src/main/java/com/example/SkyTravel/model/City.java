package com.example.SkyTravel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;

    @NonNull
    private String city_name;

    private String city_description;

    private String city_url;

    private double longitude;

    private double latitude;

    // One city can be associated with multiple movie_city entries
    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<MovieCity> movieCities;



}
