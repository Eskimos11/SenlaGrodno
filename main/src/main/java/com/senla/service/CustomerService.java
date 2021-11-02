package com.senla.service;



import com.senla.dao.CustomerDao;
import com.senla.entity.Customer;
import com.senla.entity.DiscountCard;


public class CustomerService {

    //todo Все сделано в Provider
    private CustomerDao customerDao;


    public Customer createCustomer(String name, DiscountCard discountCard) {
        Customer customer = new Customer(name, discountCard);
        return customer;
    }


}
