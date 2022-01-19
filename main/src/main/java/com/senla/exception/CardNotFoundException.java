package com.senla.exception;

import lombok.Getter;

public class CardNotFoundException extends RuntimeException{
    @Getter
    private Integer id;

    public CardNotFoundException(Integer id) {
        this.id = id;
    }

}
