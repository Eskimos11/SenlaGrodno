package com.senla.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl{
//        implements CustomerService {

//    private final CustomerDao customerDao;
//    private final CustomerConverter customerConverter;
//
//
//    @Override
//    public CustomerDto saveCustomer(CustomerDto customerDto) {
//        final Customer customer = customerConverter.convert(customerDto);
//        final Customer savedCustomer = customerDao.save(customer);
//        return customerConverter.convert(savedCustomer);
//
//    }
//
//    @Override
//    public void deleteCustomer(Integer id) {
//        customerDao.delete(id);
//    }
//
//    @Override
//    public CustomerDto getCustomerInfo(Integer id) {
//        final Customer customer = customerDao.getById(id);
//        return customerConverter.convert(customer);
//
//    }
//
//    @Override
//    public CustomerDto updateCustomer(CustomerDto customerDto) {
//        final Customer customer = customerConverter.convert(customerDto);
//        final Customer updatedCustomer = customerDao.update(customer);
//        return customerConverter.convert(updatedCustomer);
//
//    }
}
