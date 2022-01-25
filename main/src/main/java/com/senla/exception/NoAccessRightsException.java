package com.senla.exception;

import lombok.Getter;

public class NoAccessRightsException extends RuntimeException{
    @Getter
    private String message;

    public NoAccessRightsException(String message) {
        this.message = message;
    }
}
