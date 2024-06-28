package com.tp0_cac_24100_movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp0_cac_24100_movie.entity.Movie;
import com.tp0_cac_24100_movie.service.MovieService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/findAllMovies")
public class findAllMoviesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService svMovie = new MovieService();

        ArrayList<Movie> listMovies = svMovie.findAllMovie();

        if (listMovies != null) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                String listMoviesJSON = mapper.writeValueAsString(listMovies);

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(listMoviesJSON);
            } catch (Exception e) {
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                        "Ocurrió un error al devolver las películas");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NO_CONTENT, "No se encontraron películas");
        }

    }
}
