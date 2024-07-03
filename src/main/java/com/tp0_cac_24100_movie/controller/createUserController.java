package com.tp0_cac_24100_movie.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp0_cac_24100_movie.dto.UserDTO;
import com.tp0_cac_24100_movie.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createUser")
public class createUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService svUser = new UserService();

        String dataJson = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        if (dataJson != null && !dataJson.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper(); // ? Instancia Mapper (Objects | Json)
            UserDTO user = mapper.readValue(dataJson, UserDTO.class); // ? Creo una Instancia de MovieDTO con los datos
                                                                      // que me llego del Frontend
            try {
                svUser.createUser(user);

                resp.setStatus(HttpServletResponse.SC_CREATED);
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error. No se pudo dar de alta el usuario");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "No se encontraron los datos necesarios para dar de alta al usuario");
        }
    }
}
