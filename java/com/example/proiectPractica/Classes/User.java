package com.example.proiectPractica.Classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "userID")
    private Integer userId;

    private String username;

    private String password;

    private String rol;

    public User(Integer userId, String username, String password, String rol) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public User()
    {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
