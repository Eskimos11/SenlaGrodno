package com.senla.api.dao;

import com.senla.entity.Orders;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface OrdersDao extends GenericDao<Orders, Integer> {
    Orders update(Orders orders);

    void deleteById(Integer id);

}
