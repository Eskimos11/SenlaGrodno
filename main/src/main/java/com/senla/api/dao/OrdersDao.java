package com.senla.api.dao;

import com.senla.entity.Orders;
import com.senla.entity.Product;

import java.util.List;

public interface OrdersDao extends GenericDao<Orders, Long> {

    Orders update(Orders orders);

    void deleteById(Long id);

    List<Product> getProductFromOrder(Long id);
}
