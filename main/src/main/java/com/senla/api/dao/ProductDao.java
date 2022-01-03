package com.senla.api.dao;

import com.senla.entity.Product;
import com.senla.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductDao extends GenericDao<Product, Integer> {
    Product update(Product product);

    void deleteById(Integer id);

}
