package com.tp0_cac_24100_movie.dao;

import java.util.ArrayList;

import com.tp0_cac_24100_movie.entity.Movie;
import com.tp0_cac_24100_movie.dto.MovieDTO;

public interface IMovie {

    public Movie findById(Long id);

    public ArrayList<Movie> findAll();

    public void create(MovieDTO movie);

    public void delete(Long id);

    public void update(MovieDTO movie);
}
