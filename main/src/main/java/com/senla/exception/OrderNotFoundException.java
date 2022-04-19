package com.senla.exception;

import lombok.Getter;

public class OrderNotFoundException extends RuntimeException{

    @Getter
    private Long id;

    public OrderNotFoundException(Long id) {
        this.id = id;
    }
}

