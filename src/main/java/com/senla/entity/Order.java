package com.senla.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AEntity{
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customers")
    private Customer customer;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id")
    private List<Product> productList;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customers_discount_cards_id")
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
