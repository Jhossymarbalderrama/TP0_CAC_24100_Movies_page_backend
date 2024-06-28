package com.tp0_cac_24100_movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tp0_cac_24100_movie.dto.MovieDTO;
import com.tp0_cac_24100_movie.entity.Movie;

public class MovieImpl implements IMovie {

    /*
     * Request a BD, obtengo una movie, por ID
     */
    @Override
    public Movie findById(Long id) {
        String query = "select * from movie where id = " + id;
        Movie movie = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query);
            ResultSet resultSet = state.executeQuery(query);

            if (resultSet.next()) {
                movie = new Movie(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getLong(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getLong(9),
                        resultSet.getLong(10),
                        resultSet.getString(11));
            }
        } catch (Exception e) {
            System.out.println(e.toString() + movie);
        } finally {
            ConexionBD.disconnect(conexion);
        }

        return movie;
    }

    /*
     * Request a BD, obtengo listado de movie
     */
    @Override
    public ArrayList<Movie> findAll() {
        ArrayList<Movie> listMovie = new ArrayList<>();
        String query = "select * from movie";
        Connection conexion = null;

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query);
            ResultSet resultSet = state.executeQuery(query);

            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getLong(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getLong(9),
                        resultSet.getLong(10),
                        resultSet.getString(11));

                listMovie.add(movie);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            ConexionBD.disconnect(conexion);
        }
        return listMovie;
    }

    /*
     * Request a BD, Creacion de un nuevo registro, Movie
     */
    @Override
    public void create(MovieDTO movie) {
        String query = "INSERT INTO movie (title, poster, backdrop, release_date, runtime, overview, status, budget, revenue, language) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conexion = null;

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query);
            state.setString(1, movie.getTitle());
            state.setString(2, movie.getPoster());
            state.setString(3, movie.getBackdrop());
            state.setDate(4, new java.sql.Date(movie.getRelease_date().getTime()));
            state.setLong(5, movie.getRuntime());
            state.setString(6, movie.getOverview());
            state.setString(7, movie.getStatus());
            state.setLong(8, movie.getBudget());
            state.setLong(9, movie.getRevenue());
            state.setString(10, movie.getLanguage());

            state.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString() + movie);
        } finally {
            ConexionBD.disconnect(conexion);
        }
    }

    /*
     * Request BD, ELimino un registro de la BD Movie
     */
    @Override
    public void delete(Long id) {
        String query = "DELETE FROM movie WHERE id = ?";
        Connection conexion = null;

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query);
            state.setLong(1, id);

            if (state.executeUpdate() > 0) {
                System.out.println("El Usuario con ID : " + id + " ha sido eliminado.");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            ConexionBD.disconnect(conexion);
        }
    }

    /*
     * Query a BD, Modificacion de registro Movie
    */
    @Override
    public void update(MovieDTO movie) {
        StringBuilder query = new StringBuilder("UPDATE movie SET ");
        boolean first = true;
        Connection conexion = null;

        if (movie.getTitle() != null) {
            query.append(first ? "" : ", ").append("title = ?");
            first = false;
        }

        if (movie.getPoster() != null) {
            query.append(first ? "" : ", ").append("poster = ?");
            first = false;
        }

        if (movie.getBackdrop() != null) {
            query.append(first ? "" : ", ").append("backdrop = ?");
            first = false;
        }

        if (movie.getRelease_date() != null) {
            query.append(first ? "" : ", ").append("release_date = ?");
            first = false;
        }

        if (movie.getRuntime() != null) {
            query.append(first ? "" : ", ").append("runtime = ?");
            first = false;
        }

        if (movie.getOverview() != null) {
            query.append(first ? "" : ", ").append("overview = ?");
            first = false;
        }

        if (movie.getStatus() != null) {
            query.append(first ? "" : ", ").append("status = ?");
            first = false;
        }

        if (movie.getBudget() != null) {
            query.append(first ? "" : ", ").append("budget = ?");
            first = false;
        }

        if (movie.getRevenue() != null) {
            query.append(first ? "" : ", ").append("revenue = ?");
            first = false;
        }

        if (movie.getLanguage() != null) {
            query.append(first ? "" : ", ").append("language = ?");
        }

        query.append(" WHERE id = ?");

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query.toString());
            int index = 1;

            if(movie.getTitle() != null){
                state.setString(index++, movie.getTitle());
            }

            if(movie.getPoster() != null){
                state.setString(index++, movie.getPoster());
            }

            if(movie.getBackdrop() != null){
                state.setString(index++, movie.getBackdrop());
            }
            
            if(movie.getRelease_date() != null){
                state.setDate(index++, new java.sql.Date(movie.getRelease_date().getTime()));
            }
            
            if(movie.getRuntime() != null){
                state.setLong(index++, movie.getRuntime());
            }

            if(movie.getOverview() != null){
                state.setString(index++, movie.getOverview());
            }

            if(movie.getStatus() != null){
                state.setString(index++, movie.getStatus());
            }

            if(movie.getBudget() != null){
                state.setLong(index++, movie.getBudget());
            }

            if(movie.getRevenue() != null){
                state.setLong(index++, movie.getRevenue());
            }

            if(movie.getLanguage() != null){
                state.setString(index++, movie.getLanguage());
            }

            state.setLong(index, movie.getId());
            state.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            ConexionBD.disconnect(conexion);
        }
    }

}
