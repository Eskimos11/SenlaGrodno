package com.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AEntity {

    //todo Все сделано в Provider

    private String name;
    private DiscountCard discountCard;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discountCard=" + discountCard +
                '}';
    }
}
