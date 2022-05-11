package com.senla.service;

import com.senla.api.dao.ProductAmountDao;
import com.senla.entity.Orders;
import com.senla.entity.Product;
import com.senla.entity.ProductAmount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductAmountService {

    private final ProductAmountDao productAmountDao;

    public ProductAmount createProductAmount(Orders orders, Product product, Integer amount){
        ProductAmount productAmount = new ProductAmount();
        productAmount.setOrders(orders);
        productAmount.setProduct(product);
        productAmount.setAmount(amount);
        productAmountDao.save(productAmount);
        return productAmount;
    }
}
