package com.senla.service;

import com.senla.dao.CustomerDaoImpl;
import com.senla.entity.Customer;
import com.senla.entity.DiscountCard;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {

    private final CustomerDaoImpl customerDao;

    public CustomerServiceImpl(CustomerDaoImpl customerDao) {
        this.customerDao = customerDao;
    }

    public Customer createCustomer(String name, DiscountCard discountCard) {
        Customer customer = new Customer(name, discountCard);
        return customer;
    }


}
