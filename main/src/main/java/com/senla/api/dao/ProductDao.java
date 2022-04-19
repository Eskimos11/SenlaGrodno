package com.senla.api.dao;

import com.senla.entity.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product, Long> {

    Product update(Product product);

    void deleteById(Long id);

    Product getByTitle(String title);

    List<Product> getProductLimit(Integer amount);

}
