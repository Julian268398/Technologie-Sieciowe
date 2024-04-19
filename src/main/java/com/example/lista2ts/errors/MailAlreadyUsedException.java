package com.example.lista2ts.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MailAlreadyUsedException extends RuntimeException{
    private MailAlreadyUsedException (String message) {
        super(message);
    }

    public static ResponseStatusException create(String mail) {
        MailAlreadyUsedException exception = new MailAlreadyUsedException(String.format("Email: %s has been already used", mail));
        return new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage(), exception);
    }
}
