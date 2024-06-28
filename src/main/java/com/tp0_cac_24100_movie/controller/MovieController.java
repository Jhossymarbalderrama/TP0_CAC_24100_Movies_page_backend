package com.tp0_cac_24100_movie.controller;

import java.util.Calendar;

import com.tp0_cac_24100_movie.dto.MovieDTO;
import com.tp0_cac_24100_movie.service.MovieService;

public class MovieController {
    public static void main(String[] args) {
        MovieService svMovie = new MovieService();

        // ! GET MOVIE
        // Movie movie = svMovie.findByIdMovie(1l);
        // System.out.println(movie.toString());

        // ! LIST MOVIES
        // ArrayList<Movie> movies = svMovie.findAllMovie();
        // for (Movie movie : movies) {
        // System.out.println(movie.toString());
        // }


        // ! CREATE
        // MovieDTO movie = new MovieDTO();

        // ? primera MOVIE
        // movie.setTitle("Inception");
        // movie.setPoster("https://example.com/inception_poster.jpg");
        // movie.setBackdrop("https://example.com/inception_backdrop.jpg");

        // Calendar releaseDate = Calendar.getInstance();
        // releaseDate.set(2010, Calendar.JULY, 16);
        // movie.setRelease_date(releaseDate.getTime());
        // movie.setRuntime(148L);
        // movie.setOverview("A thief who steals corporate secrets through the use of dream-sharing technology "
        //         + "is given the inverse task of planting an idea into the mind of a C.E.O, "
        //         + "but his tragic past may doom the project and his team to disaster.");
        // movie.setStatus("Released");
        // movie.setBudget(160000000L);
        // movie.setRevenue(829895144L);
        // movie.setLanguage("English");

        // ? segunda MOVIE
        // movie.setTitle("The Matrix");
        // movie.setPoster("https://example.com/the_matrix_poster.jpg");
        // movie.setBackdrop("https://example.com/the_matrix_backdrop.jpg");
        // Calendar releaseDate = Calendar.getInstance();
        // releaseDate.set(1999, Calendar.MARCH, 31);
        // movie.setRelease_date(releaseDate.getTime());
        // movie.setRuntime(136L);
        // movie.setOverview("A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.");
        // movie.setStatus("Released");
        // movie.setBudget(63000000L); 
        // movie.setRevenue(466364845L); 
        // movie.setLanguage("English");


        // svMovie.createMovie(movie);

        // Movie movieNew = svMovie.findByIdMovie(2l);
        // System.out.println(movieNew.toString());

        // ! DELETE
        // svMovie.deleteMovie(1l);

        // ! UPDATE
        // MovieDTO movie = new MovieDTO();
        // movie.setId(3l);
        // movie.setTitle("The Matrix Recargado");
        // movie.setPoster("https://example.com/the_matrix_poster.jpg");
        // movie.setBackdrop("https://example.com/the_matrix_backdrop.jpg");
        // Calendar releaseDate = Calendar.getInstance();
        // releaseDate.set(1999, Calendar.MARCH, 31);
        // movie.setRelease_date(releaseDate.getTime());
        // movie.setRuntime(136L);
        // movie.setOverview("A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.");
        // movie.setStatus("Released");
        // movie.setBudget(63000000L); 
        // movie.setRevenue(466364845L); 
        // movie.setLanguage("English");

        // svMovie.updateMovie(movie);
    }
}
