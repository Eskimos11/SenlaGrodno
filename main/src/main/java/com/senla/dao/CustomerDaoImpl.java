package com.senla.dao;

import com.senla.entity.Customer;


import java.util.List;

public class CustomerDaoImpl extends AbstractDao<Customer> implements com.senla.api.dao.CustomerDao {

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
