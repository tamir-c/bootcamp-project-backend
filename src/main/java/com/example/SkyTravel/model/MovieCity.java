package com.example.SkyTravel.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@Table(name = "movie_city")
public class MovieCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_city_id;


    @ManyToOne
    @NonNull
    @JoinColumn(name = "movie_id")
    private Movie movie;


    @ManyToOne
    @NonNull
    @JoinColumn(name = "city_id")
    private City city;

}
