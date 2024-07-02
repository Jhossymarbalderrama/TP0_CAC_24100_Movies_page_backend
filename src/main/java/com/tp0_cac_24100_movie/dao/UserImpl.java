package com.tp0_cac_24100_movie.dao;

public class UserImpl{}
    /**
     * 1- Implementar la Interface IUser a la clase
     * 2- Generar los metodos de la interface (contrato)
     * 3- Codear:
     *  crear para cada metodo su consulta Query para
     *  la BD y obtener y retornar esa respuesta. (Tomar de referencia la clase MovieImpl)     
     */
    

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tp0_cac_24100_movie.dto.UserDTO;
import com.tp0_cac_24100_movie.entity.User;

public class UserImpl implements IUser {

    /*
     * Request a BD, obtengo una movie, por ID
     */
    @Override
    public User findById(Integer id) {
        Integer query = "select * from user where id = " + id;
        User user = null;
        Connection conexion = null;
    
        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query);
            ResultSet resultSet = state.executeQuery(query);
        
            if (resultSet.next()) {
                user = new User(
                        resultSet.getInteger(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInteger(9)
                        
                        );
            }
        } catch (Exception e) {
            System.out.println(e.toString() + user);
        } finally {
            ConexionBD.disconnect(conexion);
        }

        return user;
    }

    /*
     * Request a BD, obtengo listado de movie
     */ @Override
    public ArrayList<User> findAll() {
        ArrayList<User> listUser = new ArrayList<>();
        String query = "select * from user";
        Connection conexion = null;

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query);
            ResultSet resultSet = state.executeQuery(query);

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInteger(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getSring(5),
                        resultSet.getDate(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInteger(9),
                        
                        );
            
                listUser.add(user);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            ConexionBD.disconnect(conexion);
        }
        return listUser;
    }

    /*
     * Request a BD, Creacion de un nuevo registro, user
     */
    @Override
    public void create(UserDTO user) {
        String query = "INSERT INTO user (id, first_name, last_name, email, password, birthday, image, country, id_type_user, ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, )";
        Connection conexion = null;

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query);
            state.setInteger(1, user.getId());
            state.setString(2, user.getFirst_name());
            state.setString(3, user.getLast_name());
            state.setString(4, new java.sql.String(user.getId().getTime()));
            state.setString(5, user.getRuntime());
            state.setDate(6, user.getBirthday());
            state.setString(7, user.getImage());
            state.setString(8, user.getCountry());
            state.setInteger(9, user.getId_type_user());
            

            state.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString() + user);
        } finally {
            ConexionBD.disconnect(conexion);
        }
    }

    /*
     * Request BD, ELimino un registro de la BD Movie
     */
    @Override
    public void delete(Long id) {
        String query = "DELETE FROM user WHERE id = ?";
        Connection conexion = null;

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query);
            state.setInteger(1, id);

            if (state.executeUpdate() > 0) {
                System.out.println("user con ID : " + id + " ha sido eliminado.");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            ConexionBD.disconnect(conexion);
        }
    }

    /*
     * Query a BD, Modificacion de registro user
    */
    @Override
    public void update(UserDTO user) {
        StringBuilder query = new StringBuilder("UPDATE user SET ");
        boolean first = true;
        Connection conexion = null;

        if (user.getId() != null) {
            query.append(first ? "" : ", ").append("id = ?");
            first = false;
        }

        if (user.getFirst_name() != null) {
            query.append(first ? "" : ", ").append("first_name = ?");
            first = false;
        }

        if (user.getLast_name() != null) {
            query.append(first ? "" : ", ").append("last_name = ?");
            first = false;
        }

        if (user.getEmail() != null) {
            query.append(first ? "" : ", ").append("email = ?");
            first = false;
        }

        if (user.getPassword() != null) {
            query.append(first ? "" : ", ").append("password = ?");
            first = false;
        }

        if (user.getBirthday() != null) {
            query.append(first ? "" : ", ").append("birthday = ?");
            first = false;
        }

        if (user.getImage() != null) {
            query.append(first ? "" : ", ").append("image = ?");
            first = false;
        }

        if (user.getCountry() != null) {
            query.append(first ? "" : ", ").append("country = ?");
            first = false;
        }

        if (user.getid_type_user() != null) {
            query.append(first ? "" : ", ").append("id_type_user = ?");
            first = false;
        }

    

        query.append(" WHERE id = ?");

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query.toString());
            int index = 1;

            if(user.getId() != null){
                state.setInteger(index++, user.getId());
            }

            if(user.getFirst_name() != null){
                state.setString(index++, user.getfirst_name());
            }

            if(user.getLast_name() != null){
                state.setString(index++, user.getLast_name());
            }
            
            if(user.getEmail() != null){
                state.setString(index++, new java.sql.String(user.getEmail().getTime()));
            }
            
            if(user.getPassword() != null){
                state.setString(index++, user.getPassword());
            }

            if(user.getBirthday() != null){
                state.setDate(index++, user.getBirthday());
            }

            if(user.getImage() != null){
                state.setString(index++, user.getImage());
            }

            if(user.getCountry() != null){
                state.setString(index++, user.getCountry());
            }

            if(user.getId_type_user() != null){
                state.setInteger(index++, user.getId_type_user());
            }

        
        }
/* no sabia como agregarlo, revisar si esta bien
            state.setInteger(index, user.getId());
            state.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            ConexionBD.disconnect(conexion);
        }
    }*/
        }
    }
