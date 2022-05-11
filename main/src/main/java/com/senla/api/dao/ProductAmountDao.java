package com.senla.api.dao;

import com.senla.entity.ProductAmount;


public interface ProductAmountDao extends GenericDao<ProductAmount, Long> {

    ProductAmount update(ProductAmount productAmount);

    void deleteById(Long id);

}
