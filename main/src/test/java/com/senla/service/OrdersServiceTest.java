package com.senla.service;

import com.senla.BaseRepositoryTest;
import com.senla.api.dao.DetailsDao;
import com.senla.api.dao.DiscountCardDao;
import com.senla.api.dao.OrdersDao;
import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.OrdersDto.OrdersDto;
import com.senla.controller.dto.ProductDto.ProductDto;
import com.senla.dao.DetailsDaoImpl;
import com.senla.dao.DiscountCardDaoImpl;
import com.senla.dao.OrdersDaoImpl;
import com.senla.dao.ProductDaoImpl;
import com.senla.entity.Orders;
import com.senla.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ContextConfiguration(classes = {OrdersService.class, OrdersDaoImpl.class, ProductDaoImpl.class
        , DiscountCardDaoImpl.class,DiscountCardService.class, DetailsDaoImpl.class,ModelMapper.class,ProductService.class})
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrdersServiceTest extends BaseRepositoryTest{

    @Autowired
    private OrdersService ordersService;

    private ModelMapper mapper;
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductService productService;
    @Autowired
    private DiscountCardService discountCardService;
    @Autowired
    private DetailsDao detailsDao;

    @Autowired
    private DiscountCardDao discountCardDao;


//    @BeforeEach
//    public void init(){
//        when(ordersDao.save(any())).thenReturn(Orders.builder().id(1L).sum(0).build());
//        orders = ordersDao.save(Orders.builder().id(1L).sum(0).build());
//    }

    @Test
    void createOrderTest() {
        OrdersDto createOrder = ordersService.createOrder(OrdersDto.builder().sum(0).build(),1L);
//        assertEquals(1L, createOrder.getId());
        assertEquals(0,createOrder.getSum());
    }

    @Test
    void deleteOrder() {
        ordersService.deleteOrder(1L);

    }

    @Test
    void getInfoOrderById() {
//        when(ordersDao.getById(any())).thenReturn(Orders.builder().id(1L).sum(0).build());
        OrdersDto ordersDto = ordersService.getInfoOrder(1L);
        assertEquals(1L, ordersDto.getId());
        assertEquals(0,ordersDto.getSum());
    }

    @Test
    void updateOrder() {
    }

    @Test
    void addProducts() {
        ProductDto productDto = productService.createProduct(ProductDto.builder().title("MOLOKO").price(10).amount(100).build());
        ProductDto productDto1 = productService.createProduct(ProductDto.builder().title("Xleb").price(10).amount(100).build());

        OrdersDto createOrder = ordersService.createOrder(OrdersDto.builder().sum(0).build(),1L);
        ordersService.addProducts(createOrder.getId(),productDto.getId(),1);
        ordersService.addProducts(createOrder.getId(),productDto1.getId(),2);



        System.out.println("");

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