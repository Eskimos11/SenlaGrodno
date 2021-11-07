package com.senla.service;


import com.senla.api.dao.ProductDao;
import com.senla.entity.Product;


public class ProductServiceImpl {

//todo Все сделано в Provider
    private ProductDao providerDao;

    public Product createProduct(String title, int price){
        Product product = new Product(title,price);
//        providerDao.save(product);
        return product;
    }
}
