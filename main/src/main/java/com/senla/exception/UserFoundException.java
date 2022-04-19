package com.senla.exception;

import lombok.Getter;

public class UserFoundException extends RuntimeException {
    @Getter
    private String login;

    public UserFoundException(String login) {
        this.login = login;
    }
}
