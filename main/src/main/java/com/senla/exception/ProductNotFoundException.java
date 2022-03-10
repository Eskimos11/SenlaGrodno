package com.senla.exception;

import lombok.Getter;

public class ProductNotFoundException  extends RuntimeException {

    @Getter
    private final Integer id;

    public ProductNotFoundException(Integer id) {
        this.id = id;
    }
}
