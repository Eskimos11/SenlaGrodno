package com.senla.service;


import com.senla.entity.DiscountCard;

public class DiscountCardService {
    //dao discard

    //todo Все сделано в Provider
    public DiscountCard CreateDiscountCard(String number){
        DiscountCard discountCard = new DiscountCard(number);
        return discountCard;
    }
}
