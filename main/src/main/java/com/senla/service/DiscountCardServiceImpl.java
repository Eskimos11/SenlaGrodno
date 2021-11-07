package com.senla.service;


import com.senla.entity.DiscountCard;

public class DiscountCardServiceImpl {

    //todo Все сделано в Provider
    public DiscountCard CreateDiscountCard(String number){
        DiscountCard discountCard = new DiscountCard(number);
        return discountCard;
    }
}
