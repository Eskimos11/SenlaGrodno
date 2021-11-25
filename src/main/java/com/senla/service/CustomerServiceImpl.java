package com.senla.service;

import com.senla.api.dao.CustomerDao;
import com.senla.api.service.CustomerService;
import com.senla.controller.dto.CustomerDto;
import com.senla.entity.Customer;
import com.senla.service.converter.CustomerConverter;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;
    private final CustomerConverter customerConverter;

    public CustomerServiceImpl(CustomerDao customerDao, CustomerConverter customerConverter) {
        this.customerDao = customerDao;
        this.customerConverter = customerConverter;
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        final Customer customer = customerConverter.convert(customerDto);
        final Customer savedCustomer = customerDao.save(customer);
        return customerConverter.convert(savedCustomer);

    }

    @Override
    public void deleteCustomer(Integer id) {
        customerDao.delete(id);
    }

    @Override
    public CustomerDto getCustomerInfo(Integer id) {
        final Customer customer = customerDao.getById(id);
        return customerConverter.convert(customer);

    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        final Customer customer = customerConverter.convert(customerDto);
        final Customer updatedCustomer = customerDao.update(customer);
        return customerConverter.convert(updatedCustomer);

    }
}
