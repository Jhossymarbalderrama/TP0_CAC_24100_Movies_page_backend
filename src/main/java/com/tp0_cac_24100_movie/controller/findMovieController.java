package com.tp0_cac_24100_movie.controller;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp0_cac_24100_movie.entity.Movie;
import com.tp0_cac_24100_movie.service.MovieService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/findMovieByID")
public class findMovieController extends HttpServlet {    
    /**
     * ENDPOINT - GET MOVIE by ID
     */
    @Override        
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieService svMovie = new MovieService();
        String idParam = req.getParameter("id"); // ? Obtengo el id de la request params

        if (idParam != null && !idParam.isEmpty()) {
            try {
                Long id = Long.parseLong(idParam);
                Movie movie = svMovie.findByIdMovie(id);
            
                ObjectMapper mapper = new ObjectMapper(); // ? Instancia Mapper para JSON
                String movieJSON = mapper.writeValueAsString(movie);                
                
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(movieJSON);// ? Return Response Backend 
                // resp.getWriter().println(movieJSON);
                resp.setStatus(HttpServletResponse.SC_OK);
            }catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ocurrio un error para devolver la movie");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "No se encontro el parametro 'ID'");
        }
    }
}
