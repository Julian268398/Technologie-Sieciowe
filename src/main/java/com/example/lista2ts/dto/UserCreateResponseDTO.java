package com.example.lista2ts.dto;

import jakarta.validation.constraints.NotNull;

public class UserCreateResponseDTO {
    private long id;

    private String mail;

    private String name;

    public UserCreateResponseDTO() {
    }

    public UserCreateResponseDTO(long id, String mail, String name) {
        this.id = id;
        this.mail = mail;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
