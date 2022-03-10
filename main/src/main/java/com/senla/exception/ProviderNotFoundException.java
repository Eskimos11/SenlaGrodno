package com.senla.exception;

import lombok.Getter;

public class ProviderNotFoundException extends RuntimeException {

    @Getter
    private final Integer id;

    public ProviderNotFoundException(Integer id) {
        this.id = id;
    }
}
