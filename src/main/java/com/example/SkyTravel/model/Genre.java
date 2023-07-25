package com.example.SkyTravel.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genre_id;

    @NonNull
    private String genre_name;


    // One genre can be associated with multiple movies
    @OneToMany(mappedBy = "genre", fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Movie> movies;



}
