package com.senla.api.dao;

import com.senla.entity.Orders;
import com.senla.entity.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrdersDao extends GenericDao<Orders, Integer> {
    Orders update(Orders orders);

    void deleteById(Integer id);

    List<Orders> getAll();

    List<Product> getProduct(Integer id);
}
