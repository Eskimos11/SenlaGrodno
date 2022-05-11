package com.senla.service;

import com.senla.api.dao.*;
import com.senla.controller.dto.OrdersDto.OrdersDto;
import com.senla.entity.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrdersServiceTest {

    @InjectMocks
    private OrdersService ordersService;
    @Spy
    private ModelMapper mapper;
    @Mock
    private OrdersDao ordersDao;
    @Mock
    private ProductDao productDao;
    @InjectMocks
    private ProductService productService;
    @Mock
    private DiscountCardService discountCardService;
    @Mock
    private DetailsDao detailsDao;
    @Mock
    private ProductAmountDao productAmountDao;
    @Mock
    private ProductAmountService productAmountService;
    @Mock
    private DiscountCardDao discountCardDao;

    private Orders order;


//    @BeforeEach
//    public void init(){
//
//        when(ordersDao.save(any())).thenReturn(Orders.builder().id(1L).statusOrder(false).sum(0).userId(1L).build());
//        order = ordersDao.save(Orders.builder().sum(0).userId(1L).build());
//
//    }

    @Test
    @Order(1)
    void createOrderTest() {
        when(ordersDao.save(any())).thenReturn(Orders.builder().id(1L).statusOrder(false).sum(0).userId(1L).build());
        OrdersDto createOrder = ordersService.createOrder(OrdersDto.builder().sum(0).build(),1L);
        assertNotNull(createOrder.getId());
        assertEquals(0,createOrder.getSum());
        assertFalse(order.isStatusOrder());
        assertEquals(1L,order.getUserId());

    }

    @Test
    void deleteOrder() {
        ordersService.deleteOrder(1L);


    }

    @Test
    @Order(2)
    void getInfoOrderById() {
        when(ordersDao.getById(order.getId())).thenReturn(Orders.builder().id(1L).sum(0).statusOrder(false).userId(1L).build());
        OrdersDto ordersDto = ordersService.getInfoOrder(1L);
        assertEquals(1L, ordersDto.getId());
        assertEquals(0,ordersDto.getSum());
        assertFalse(order.isStatusOrder());
        assertEquals(1L,order.getUserId());
    }

    @Test
    void updateOrder() {
    }

    @Test
    @Order(3)
    void addProductToOrder() {
        Orders orders = Orders.builder().id(1L).sum(0).statusOrder(false).userId(1L).build();
        Product product = Product.builder().id(1L).title("XLEB").price(11).amount(10).build();
        when(ordersDao.getById(any())).thenReturn(orders);
        when(productDao.getById(product.getId())).thenReturn(product);
        when(ordersDao.update(any())).thenReturn(Orders.builder().productList(List.of(product)).build());
        when(productAmountService.createProductAmount(orders, product, 1))
                                                   .thenReturn(ProductAmount.builder().product(product).orders(orders).amount(1).build());

        ordersService.addProducts(orders.getId(),product.getId(),1);
        assertEquals(1,orders.getProductList().size());
        assertEquals(product,orders.getProductList().get(0));
    }

    @Test
    @Order(4)
    void addDiscountCardToOrder() {
        Orders orders = Orders.builder().id(1L).sum(10).statusOrder(false).userId(1L).build();
        DiscountCard discountCard = DiscountCard.builder().id(1L).status(Status.BRONZE).number("123").balance(10).build();
        when(discountCardDao.getByNumber(any())).thenReturn(discountCard);
        when(ordersDao.getById(orders.getId())).thenReturn(orders);
        when(discountCardDao.update(any())).thenReturn(DiscountCard.builder().id(1L).status(Status.BRONZE).number("123").balance(20).build());
        when(discountCardService.changeStatus("123")).thenReturn(DiscountCard.builder().id(1L).status(Status.BRONZE).number("123").balance(10).build());
        when(ordersDao.update(orders)).thenReturn(Orders.builder().id(1L).sum(7).discountCard(DiscountCard.builder().id(1L).status(Status.BRONZE).number("123").balance(10).build()).build());
        ordersService.addDiscountCardToOrder(orders.getId(),discountCard.getNumber(),1L);
        assertEquals(discountCard,orders.getDiscountCard());


    }

    @Test
    void getProductFromOrder() {
        Product product1 = Product.builder().id(1L).title("XLEB").price(11).amount(10).build();
        Product product2 = Product.builder().id(1L).title("XLEB").price(11).amount(10).build();
        when(ordersDao.getProductFromOrder(1L)).thenReturn(List.of(product1,product2));

                Orders.builder().id(1L).productList(List.of(product1,product2)).sum(10).statusOrder(false).userId(1L).build();
        List<Product> productList = ordersDao.getProductFromOrder(1L);
        assertEquals(2,productList.size());

    }
//
//    @Test
//    void giveDiscount() {
//    }
}