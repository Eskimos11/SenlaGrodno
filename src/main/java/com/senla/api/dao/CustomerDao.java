package com.senla.api.dao;

import com.senla.entity.Customer;

import javax.transaction.Transactional;

@Transactional
public interface CustomerDao extends GenericDao<Customer> {

    Customer getByIdWith(Integer id);
}
