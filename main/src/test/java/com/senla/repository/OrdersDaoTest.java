package com.senla.repository;

import com.senla.BaseRepositoryTest;
import com.senla.api.dao.OrdersDao;
import com.senla.dao.OrdersDaoImpl;
import com.senla.entity.Orders;
import com.senla.entity.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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
        Orders orders1 = ordersDao.save(Orders.builder().sum(0).build());
        assertNotNull(ordersDao.getById(orders1.getId()));
    }

    @Test
    public void removeOrderById() {
        ordersDao.deleteById(orders.getId());
        Orders potentialOrder = ordersDao.getById(orders.getId());
        assertNull(potentialOrder);
    }

    @Test
    public void updateOrderTest() {

        Orders updateOrders = ordersDao.save(
                Orders.builder()
                        .sum(10)
                        .build());
        orders = ordersDao.update(updateOrders);
        assertEquals(orders.getId(), updateOrders.getId());
        assertEquals(10, orders.getSum());
    }

    @Test
    public void getProductFromOrderTest() {
        Orders potentialOrder = ordersDao.save(Orders.builder().sum(0).productList(List.of(Product.builder()
                .title("XLEB")
                .price(11)
                .amount(10)
                .build())).build());

        List<Product> productList = ordersDao.getProductFromOrder(potentialOrder.getId());
        assertEquals(1, productList.size());
    }


}

