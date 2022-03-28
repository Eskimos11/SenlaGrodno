package com.senla.exception;

import lombok.Getter;

public class CardNotFoundException extends RuntimeException{
    @Getter
    private Long id;

    public CardNotFoundException(Long id) {
        this.id = id;
    }

}
