package com.tp0_cac_24100_movie.service;

import java.util.ArrayList;

import com.tp0_cac_24100_movie.dao.IUser;
import com.tp0_cac_24100_movie.dao.UserImpl;
import com.tp0_cac_24100_movie.dto.UserDTO;
import com.tp0_cac_24100_movie.entity.User;

public class UserService {public class UserService {

    private IUser user;

    public UserService(){
        user = new UserImpl();
    }

    // ? GET 
    public User findByIdUser(Integer id){
        return this.user.findById(id);
    }
    
    // ? GET list 
    public ArrayList<User> findAllUser(){
        return this.user.findAll();
    }

    // ? CREATE 
    public void createUser(UserDTO mv){
        this.user.create(mv);
    }

    // ? DELETE  by ID
    public void deleteUser(Integer id){
        this.user.delete(id);
    }

    // ? UPDATE 
    public void updaUser(UserDTO mv){
        this.user.update(mv);
    }    
}

    
}
