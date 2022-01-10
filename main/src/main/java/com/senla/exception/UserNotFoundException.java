package com.senla.exception;

import liquibase.pro.packaged.S;
import lombok.Getter;

public class UserNotFoundException extends RuntimeException {

    @Getter
    private Integer id;

    public UserNotFoundException(Integer id) {
        this.id = id;
    }
}
