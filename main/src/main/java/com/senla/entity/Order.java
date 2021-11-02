package com.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends AEntity{

    //todo Все сделано в Provider

    private Customer customer;
    private List<Product> productList;
    private DiscountCard discountCard;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", productList=" + productList +
                ", discountCard=" + discountCard +
                '}';
    }
}
