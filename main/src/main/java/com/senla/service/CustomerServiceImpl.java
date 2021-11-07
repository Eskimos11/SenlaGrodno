package com.senla.service;

import com.senla.dao.CustomerDaoImpl;
import com.senla.entity.Customer;
import com.senla.entity.DiscountCard;

public class CustomerServiceImpl {

    //todo Все сделано в Provider
    private CustomerDaoImpl customerDao;

    public Customer createCustomer(String name, DiscountCard discountCard) {
        Customer customer = new Customer(name, discountCard);
        return customer;
    }


}
