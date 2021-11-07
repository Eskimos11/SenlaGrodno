package com.senla.service;


import com.senla.entity.Customer;
import com.senla.entity.DiscountCard;
import com.senla.entity.Order;
import com.senla.entity.Product;

import java.util.List;


public class OrderServiceImpl {

    //todo Все сделано в Provider

    public Order CreateOrder(Customer customer, List<Product> product, DiscountCard discountCard) {
        Order order = new Order(customer, product, discountCard);
        return order;
    }

}

