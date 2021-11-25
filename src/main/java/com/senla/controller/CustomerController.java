package com.senla.controller;

import com.senla.controller.dto.CustomerDto;
import com.senla.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    public void createCustomer(CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
    }

    public void deleteCustomer(Integer id) {
        customerService.deleteCustomer(id);
    }

    public CustomerDto getCustomer(Integer id) {
        return customerService.getCustomerInfo(id);
    }

    public CustomerDto updateCustomer(CustomerDto customerDto) {
        customerService.updateCustomer(customerDto);
        return customerDto;
    }
}
