package com.senla.converter;

import com.senla.controller.dto.CustomerDto;
import com.senla.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public Customer convert(CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.getName())
                .discountCard(customerDto.getDiscountCard())
                .build();
    }

    public CustomerDto convert(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .discountCard(customer.getDiscountCard())
                .build();
    }
}
