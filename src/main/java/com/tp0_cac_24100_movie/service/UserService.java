package com.tp0_cac_24100_movie.service;

import java.util.ArrayList;

import com.tp0_cac_24100_movie.dao.IUser;
import com.tp0_cac_24100_movie.dao.UserImpl;
import com.tp0_cac_24100_movie.dto.UserDTO;
import com.tp0_cac_24100_movie.entity.User;

public class UserService {

    private IUser user;

    public UserService() {
        user = new UserImpl();
    }

    // ? GET
    public User findByIdUser(Long id) {
        return this.user.findById(id);
    }

    // ? GET list
    public ArrayList<User> findAllUser() {
        return this.user.findAll();
    }

    // ? CREATE
    public void createUser(UserDTO user) {
        this.user.create(user);
    }

    // ? DELETE by ID
    public void deleteUser(Long id) {
        this.user.delete(id);
    }

    // ? UPDATE
    public void updaUser(UserDTO user) {
        this.user.update(user);
    }
}
