package com.senla.api.dao;

import com.senla.entity.Orders;

public interface OrdersDao extends GenericDao<Orders, Integer> {

    Orders update(Orders orders);

    void deleteById(Integer id);

}
