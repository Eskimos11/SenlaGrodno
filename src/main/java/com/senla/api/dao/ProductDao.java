package com.senla.api.dao;

import com.senla.entity.Product;

import javax.transaction.Transactional;

@Transactional
public interface ProductDao extends GenericDao<Product> {

}
