package com.tp0_cac_24100_movie.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Date birthday;
    private String image;
    private String country;
    private Integer id_type_user;
    
    
    
    public User(Integer id, String first_name, String last_name, String email, String password,Date birthday,
            String image, String country, Integer id_type_user,) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email= email;
        this.password = password;
        this.birthday = birthday;
        this.image = image;
        this.country = country;
        this.id_type_user = id_type_user;
    
        
    }

    public User(Integer id , String first_name, String last_name, String email, String password,
            Date birthday, String image, String country, Integer id_type_user) {
        this.id= id;
        this.first_name= first_name;
        this.last_name = last_name;
        this.email= email;
        this.password = password;
        this.birthday = birthday;
        this.image = image;
        this.id_type_user = id_type_user;
    
         }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getId_type_user() {
        return id_type_user;
    }

    public void setId_type_user(Integer id_type_user) {
        this.id_type_user = id_type_user;
    }
          @Override
    public String toString() {
        return "User[id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
                + ", password=" + password + ", birthday=" + birthday + ", image=" + image + ", country="
                + country + ", id_type_user=" +id_type_user "]";
    }
    
}
