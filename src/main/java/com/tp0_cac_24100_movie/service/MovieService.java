package com.tp0_cac_24100_movie.service;

import java.util.ArrayList;

import com.tp0_cac_24100_movie.dao.IMovie;
import com.tp0_cac_24100_movie.dao.MovieImpl;
import com.tp0_cac_24100_movie.dto.MovieDTO;
import com.tp0_cac_24100_movie.entity.Movie;;

public class MovieService {

    private IMovie movies;

    public MovieService(){
        movies = new MovieImpl();
    }

    // ? GET movie
    public Movie findByIdMovie(Long id){
        return this.movies.findById(id);
    }
    
    // ? GET list movies
    public ArrayList<Movie> findAllMovie(){
        return this.movies.findAll();
    }

    // ? CREATE movie
    public void createMovie(MovieDTO mv){
        this.movies.create(mv);
    }

    // ? DELETE movie by ID
    public void deleteMovie(Long id){
        this.movies.delete(id);
    }

    // ? UPDATE movie 
    public void updateMovie(MovieDTO mv){
        this.movies.update(mv);
    }    
}
