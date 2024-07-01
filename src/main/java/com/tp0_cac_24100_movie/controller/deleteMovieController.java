package com.tp0_cac_24100_movie.controller;

import java.io.IOException;

import com.tp0_cac_24100_movie.service.MovieService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteMovie")
public class deleteMovieController extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService svMovie = new MovieService();
        String idParam = req.getParameter("id"); // ? Id de la movie a Eliminar

        if (idParam != null && !idParam.isEmpty()) {
            try {
                Long id = Long.parseLong(idParam);
                svMovie.deleteMovie(id);

                resp.setStatus(HttpServletResponse.SC_OK);
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error. No se pudo eliminar la Movie con la ID " + idParam);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "No se encontro el parametro 'ID'");
        }
    }
}
