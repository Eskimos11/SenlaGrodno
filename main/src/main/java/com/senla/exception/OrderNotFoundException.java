package com.senla.exception;

import lombok.Getter;

public class OrderNotFoundException extends RuntimeException{

    @Getter
    private Integer id;

    public OrderNotFoundException(Integer id) {
        this.id = id;
    }
}

