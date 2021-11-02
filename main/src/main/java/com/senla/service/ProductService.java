package com.senla.service;


import com.senla.api.dao.IProductDao;
import com.senla.entity.Product;


public class ProductService {

//todo Все сделано в Provider
    private IProductDao providerDao;

    public Product createProduct(String title, int price){
        Product product = new Product(title,price);
//        providerDao.save(product);
        return product;
    }
}
