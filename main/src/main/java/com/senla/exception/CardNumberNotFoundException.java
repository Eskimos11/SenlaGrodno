package com.senla.exception;

import lombok.Getter;

public class CardNumberNotFoundException extends RuntimeException {

    @Getter
    private String number;

    public CardNumberNotFoundException(String number) {
        this.number = number;
    }

}
