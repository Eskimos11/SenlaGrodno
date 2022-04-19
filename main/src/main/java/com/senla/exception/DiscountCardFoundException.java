package com.senla.exception;

import lombok.Getter;

public class DiscountCardFoundException extends RuntimeException{
    @Getter
    private String login;

    public DiscountCardFoundException(String login) {
        this.login = login;
    }
}
