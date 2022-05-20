package com.senla.exception;

import lombok.Getter;

public class CloseOrderException extends RuntimeException {

    @Getter
    private String message;

    public CloseOrderException() {

    }
}


