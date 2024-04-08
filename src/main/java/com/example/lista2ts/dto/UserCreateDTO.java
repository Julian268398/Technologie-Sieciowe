package com.example.lista2ts.dto;


public class UserCreateDTO {

    private String userName;

    private String password;

    private String role;

    private String mail;

    private String name;

    public UserCreateDTO() {
    }

    public UserCreateDTO(String userName, String password, String role, String mail, String name) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.mail = mail;
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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
