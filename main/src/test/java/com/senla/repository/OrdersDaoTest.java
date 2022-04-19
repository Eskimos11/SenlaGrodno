package com.senla.repository;

import com.senla.BaseRepositoryTest;
import com.senla.api.dao.OrdersDao;
import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.ProductDto.ProductDto;
import com.senla.dao.OrdersDaoImpl;
import com.senla.dao.ProductDaoImpl;
import com.senla.entity.Orders;
import com.senla.entity.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = OrdersDaoImpl.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrdersDaoTest extends BaseRepositoryTest {

    @Autowired
    private OrdersDao ordersDao;


    private Orders orders;

    @BeforeAll
    public void init() {
        orders = ordersDao.save(Orders.builder().sum(0).productList(List.of(Product.builder()
                .title("XLEB")
                .price(11)
                .amount(10)
                .build())).build());

    }

    @Test
    public void jpaShouldSetIdWhenEntitySaved() {
        assertNotNull(orders.getId());
    }
    //todo
    @Test
    public void getOrderById() {
//        assertNotNull(ordersDao.getById(orders.getId()));
//        assertEquals(potentialOrder.getId(), orders.getId());
    }

    @Test
    public void removeOrderById() {
        ordersDao.deleteById(orders.getId());
        Orders potentialOrder = ordersDao.getById(orders.getId());
        assertNull(potentialOrder);
    }
    //todo
    //Переделать Update
    @Test
    public void updateOrderTest() {
               List<Product> productList = List.of(Product.builder()
                        .title("XLEB")
                        .price(11)
                        .amount(10)
                        .build());
        Orders updateOrders = ordersDao.save(
                Orders.builder()
                        .sum(10)
                        .productList(productList)
                        .build());
        orders = ordersDao.update(updateOrders);


        assertEquals(orders.getId(), updateOrders.getId());
    }
    @Test
    public void getProductFromOrder(){
        List<Product> productList = ordersDao.getProductFromOrder(orders.getId());
        assertEquals(1, productList.size());
    }


}

