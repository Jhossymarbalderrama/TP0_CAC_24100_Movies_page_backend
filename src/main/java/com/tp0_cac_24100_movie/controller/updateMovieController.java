package com.tp0_cac_24100_movie.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp0_cac_24100_movie.dto.MovieDTO;
import com.tp0_cac_24100_movie.service.MovieService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateMovie")
public class updateMovieController extends HttpServlet{

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService svMovie = new MovieService();

        String dataJson = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        if (dataJson != null && !dataJson.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper(); 
            MovieDTO movie = mapper.readValue(dataJson, MovieDTO.class); 
            try {
                svMovie.updateMovie(movie);

                resp.setStatus(HttpServletResponse.SC_OK);
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar la Movie");
            }
        }else{
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Datos insuficientes para actualizar la Movie");
        }
    }
}
