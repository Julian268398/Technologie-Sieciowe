package com.example.lista2ts.dto;

import com.example.lista2ts.commonTypes.UserRole;

public class RegisterDTO {
    private String password;

    private String username;

    private UserRole role;

    private String mail;

    private String name;

    public RegisterDTO(String password, String username, UserRole role, String mail, String name) {
        this.password = password;
        this.username = username;
        this.role = role;
        this.mail = mail;
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
