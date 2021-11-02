package com.senla.dao;

import com.senla.api.dao.ICustomerDao;

import com.senla.entity.Customer;


import java.util.List;

public class CustomerDao extends AbstractDao<Customer> implements ICustomerDao {

    //todo Все сделано в Provider
    @Override
    public void saveAll(List<Customer> entity) {

    }

    @Override
    public Customer getById(Integer id) {
        return null;
    }

    @Override
    public void delete(Customer entity) {

    }

    @Override
    public Customer update(Customer entity) {
        return null;
    }
}
