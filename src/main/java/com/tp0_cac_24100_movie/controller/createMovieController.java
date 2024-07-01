package com.tp0_cac_24100_movie.controller;

import java.io.IOException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp0_cac_24100_movie.dto.MovieDTO;
import com.tp0_cac_24100_movie.service.MovieService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createMovie")
public class createMovieController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService svMovie = new MovieService();

        String dataJson = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        if (dataJson != null && !dataJson.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper(); // ? Instancia Mapper (Objects | Json)
            MovieDTO movie = mapper.readValue(dataJson, MovieDTO.class); // ? Creo una Instancia de MovieDTO con los datos que me llego del Frontend
            try {
                svMovie.createMovie(movie);

                resp.setStatus(HttpServletResponse.SC_CREATED);
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error. No se pudo dar de alta la Movie");
            }
        }else{
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "No se encontraron los datos necesarios para dar de alta a la Movie");
        }
    }
}
