package com.senla.api.dao;

import com.senla.entity.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProductDao extends GenericDao<Product, Integer> {

    Product update(Product product);

    void deleteById(Integer id);

    Product getByTitle(String title);

    List<Product> getProductLimit(Integer amount);

    List<Product> getProduct(Integer id);

}
