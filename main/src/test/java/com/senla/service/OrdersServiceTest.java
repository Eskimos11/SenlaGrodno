package com.senla.service;

import com.senla.api.dao.OrdersDao;
import com.senla.controller.dto.OrdersDto;
import com.senla.entity.Orders;
import com.senla.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrdersServiceTest {
    @InjectMocks
    private OrdersService ordersService;
    @Spy
    private ModelMapper mapper;
    @Mock
    private OrdersDao ordersDao;

    @Test
    public void getSumTest(){
        Product product = new Product(1,"Pivo",12,2);
        Product product1 = new Product(2,"KVAS",10,2);
        final Integer sum = 44;
        final List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        Orders orders = Orders.builder().id(123).productList(productList).build();
        int a =  ordersService.getSumOrder(orders);
        assertEquals(sum, a);
}
    @Test
    public void createOrders(){
        Product product = new Product(1,"Pivo",12,2);
        final List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(ordersDao.save(any())).thenReturn(Orders.builder().productList(productList).id(123).build());
        OrdersDto ordersDto = ordersService.saveOrder(
                OrdersDto.builder().id(123).product(productList).build());
    }
    @Test
    public void allProduct(){
        Product product = new Product(1,"Pivo",12,2);
        final List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(ordersDao.save(any())).thenReturn(Orders.builder().id(123).build());
        OrdersDto ordersDto = ordersService.saveOrder(
                OrdersDto.builder().id(123).build());
        ordersService.addProducts(productList);
    }
}