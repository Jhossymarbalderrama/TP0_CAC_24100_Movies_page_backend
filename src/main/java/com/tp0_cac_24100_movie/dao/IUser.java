package com.tp0_cac_24100_movie.dao;

import java.util.ArrayList;

import com.tp0_cac_24100_movie.dto.UserDTO;
import com.tp0_cac_24100_movie.entity.User;

public interface IUser {
    
    public User findById(Long id);

    public ArrayList<User> findAll();

    public void create(UserDTO user);

    public void delete(Long id);

    public void update(UserDTO user);
}


