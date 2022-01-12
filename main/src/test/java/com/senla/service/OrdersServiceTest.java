package com.senla.service;

import com.senla.api.dao.OrdersDao;
import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.OrdersDto.OrdersDto;
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
    @Mock
    private ProductDao productDao;

    @Test
    public void getSumTest() {
        Product product1 = new Product(2, "Cola", 10, 5,2);
        int realAmount = 20;
        int sum = ordersService.getSumOrder(product1);
        assertEquals(realAmount, sum);
    }

    @Test
    public void createOrdersTest() {

        when(ordersDao.save(any())).thenReturn(Orders.builder().id(123).sum(0).build());

        final OrdersDto ordersDto = ordersService.saveOrder(
                OrdersDto.builder()
                        .id(123)
                        .sum(0)
                        .build());
        assertEquals(123, ordersDto.getId());
        assertEquals(0, ordersDto.getSum());
    }

//    @Test
//    public void addProductTest() {
//        when(ordersDao.save(any())).thenReturn(Orders.builder().id(123).sum(0).build());
//        Product product1 = new Product(2, "Cola", 10, 5,2);
//        final OrdersDto ordersDto = ordersService.saveOrder(
//                OrdersDto.builder()
//                        .id(123)
//                        .sum(0)
//                        .build());
//        ordersService.addProducts(123,2,2);
//    }
}