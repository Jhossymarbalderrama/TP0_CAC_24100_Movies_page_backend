package com.tp0_cac_24100_movie.entity;

import java.util.Date;

public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Date birthday;
    private String country;
    private String image;
    private Long id_type_user;

    public User(Long id, String firstname, String lastname, String email, String password, Date birthday,
            String image, String country, Long id_type_user) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.image = image;
        this.country = country;
        this.id_type_user = id_type_user;
    }

    public User(String firstname, String lastname, String email, String password,
            Date birthday, String image, String country, Long id_type_user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.image = image;
        this.id_type_user = id_type_user;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
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

    public Long getId_type_user() {
        return id_type_user;
    }

    public void setId_type_user(Long id_type_user) {
        this.id_type_user = id_type_user;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
                + ", password=" + password + ", birthday=" + birthday + ", image=" + image + ", country=" + country
                + ", id_type_user=" + id_type_user + "]";
    }
}
