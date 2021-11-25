package com.senla.api.service;

import com.senla.controller.dto.CustomerDto;

public interface CustomerService {

    CustomerDto saveCustomer(CustomerDto customerDto);

    void deleteCustomer(Integer id);

    CustomerDto getCustomerInfo(Integer id);

    CustomerDto updateCustomer(CustomerDto customerDto);
}
