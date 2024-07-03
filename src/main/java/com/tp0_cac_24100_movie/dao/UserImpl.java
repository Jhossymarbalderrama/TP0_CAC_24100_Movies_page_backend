package com.tp0_cac_24100_movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tp0_cac_24100_movie.dto.UserDTO;
import com.tp0_cac_24100_movie.entity.User;

public class UserImpl implements IUser {

    /*
     * Request a BD, obtengo una user, por ID
     */
    @Override
    public User findById(Long id) {
        String query = "select * from user where id = " + id;
        User user = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query);
            ResultSet resultSet = state.executeQuery(query);

            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getLong(9));
            }
        } catch (Exception e) {
            System.out.println(e.toString() + user);
        } finally {
            ConexionBD.disconnect(conexion);
        }

        return user;
    }

    /*
     * Request a BD, obtengo listado de users
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
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getLong(9));

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
        String query = "INSERT INTO user (firstname, lastname, email, password, birthday, image, country, id_type_user ) values(?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conexion = null;

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query);
            state.setString(1, user.getfirstname());
            state.setString(2, user.getlastname());
            state.setString(3, user.getEmail());
            state.setString(4, user.getPassword());
            state.setDate(5, new java.sql.Date(user.getBirthday().getTime()));
            state.setString(6, user.getImage());
            state.setString(7, user.getCountry());
            state.setLong(8, user.getId_type_user());

            state.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString() + user);
        } finally {
            ConexionBD.disconnect(conexion);
        }
    }

    /*
     * Request BD, ELimino un registro de la BD User
     */
    @Override
    public void delete(Long id) {
        String query = "DELETE FROM user WHERE id = ?";
        Connection conexion = null;

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query);
            state.setLong(1, id);

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

        if (user.getfirstname() != null) {
            query.append(first ? "" : ", ").append("firstname = ?");
            first = false;
        }

        if (user.getlastname() != null) {
            query.append(first ? "" : ", ").append("lastname = ?");
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

        if (user.getId_type_user() != null) {
            query.append(first ? "" : ", ").append("id_type_user = ?");
            first = false;
        }

        query.append(" WHERE id = ?");

        try {
            conexion = ConexionBD.connect();
            PreparedStatement state = conexion.prepareStatement(query.toString());
            int index = 1;

            if (user.getfirstname() != null) {
                state.setString(index++, user.getfirstname());
            }

            if (user.getlastname() != null) {
                state.setString(index++, user.getlastname());
            }

            if (user.getEmail() != null) {
                state.setString(index++, user.getEmail());
            }

            if (user.getPassword() != null) {
                state.setString(index++, user.getPassword());
            }

            if (user.getBirthday() != null) {
                state.setDate(index++, new java.sql.Date(user.getBirthday().getTime()));
            }

            if (user.getImage() != null) {
                state.setString(index++, user.getImage());
            }

            if (user.getCountry() != null) {
                state.setString(index++, user.getCountry());
            }

            if (user.getId_type_user() != null) {
                state.setLong(index++, user.getId_type_user());
            }

            state.setLong(index, user.getId());
            state.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            ConexionBD.disconnect(conexion);
        }
    }
}
