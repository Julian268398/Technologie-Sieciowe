package com.example.lista2ts.dto;


import jakarta.validation.constraints.NotNull;

public class UserCreateDTO {


    private String mail;

    private String name;

    public UserCreateDTO() {
    }

    public UserCreateDTO(String mail, String name) {
        this.mail = mail;
        this.name = name;
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
