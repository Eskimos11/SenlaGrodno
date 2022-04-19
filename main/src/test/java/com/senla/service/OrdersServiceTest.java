package com.senla.service;

import com.senla.api.dao.OrdersDao;
import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.OrdersDto.OrdersDto;
import com.senla.controller.dto.ProductDto.ProductCreateDto;
import com.senla.entity.Orders;
import com.senla.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

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
    void createOrder() {
        when(ordersDao.save(any())).thenReturn(Orders.builder().id(1L).sum(0).build());
        OrdersDto ordersDto = OrdersDto.builder().id(1L).sum(0).build();
        OrdersDto createOrder = ordersService.createOrder(ordersDto,1L);
        assertEquals(1L, createOrder.getId());
        assertEquals(0,createOrder.getSum());
    }

    @Test
    void deleteOrder() {

    }
//    @Test
//    public void getUserInfoTest() {
//        when(productDao.getById(any())).thenReturn(Product.builder().title("XLEB").price(11).amount(10).build());
//        ProductCreateDto productDto = productService.getProductInfo(1L);
//        assertEquals("XLEB", productDto.getTitle());
//        assertEquals(11, productDto.getPrice());
//        assertEquals(10, productDto.getAmount());
//    }
    @Test
    void getInfoOrderById() {
        when(ordersDao.getById(any())).thenReturn(Orders.builder().id(1L).sum(0).build());
        OrdersDto ordersDto = ordersService.getInfoOrder(1L);
        assertEquals(1L, ordersDto.getId());
        assertEquals(0,ordersDto.getSum());
    }

    @Test
    void updateOrder() {
    }

    @Test
    void addProducts() {
    }

    @Test
    void addDiscountCard() {
    }

    @Test
    void getProductOrders() {
    }

    @Test
    void giveDiscount() {
    }
}