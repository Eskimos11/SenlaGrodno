package com.senla.service;

import com.senla.api.dao.OrdersDao;
import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.OrdersDto.OrderGetDto;
import com.senla.controller.dto.OrdersDto.OrdersDto;
import com.senla.entity.Orders;
import com.senla.entity.Product;
import com.senla.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersDao ordersDao;
    private final ProductDao productDao;
    private final ModelMapper mapper;

    public OrdersDto saveOrder(OrdersDto ordersDto) {
        final Orders orders = mapper.map(ordersDto, Orders.class);
        final Orders savedOrders = ordersDao.save(orders);
        return mapper.map(savedOrders, OrdersDto.class);
    }

    public void deleteOrder(Integer id) {
        ordersDao.deleteById(id);
    }

    public OrderGetDto getInfoOrder(Integer id) {
        final Orders orders = ofNullable(ordersDao.getById(id))
                .orElseThrow(() -> new OrderNotFoundException(id));
        return mapper.map(orders, OrderGetDto.class);
    }

    public OrdersDto updateOrder(OrdersDto ordersDto) {
        final Orders orders = mapper.map(ordersDto, Orders.class);
        final Orders updatedOrders = ordersDao.update(orders);
        return mapper.map(updatedOrders, OrdersDto.class);
    }

    public OrderGetDto addProducts(Integer orderId, Integer productId, Integer amount) {
        Orders orders = ordersDao.getById(orderId);
        Product product = productDao.getById(productId);
        List<Product> productListOrders = orders.getProductList();
        product.setPurchaseQuantity(amount);
        productListOrders.add(product);
        orders.setProductList(productListOrders);
        orders.setSum(getSumOrder(product) + orders.getSum());
        Product updateProduct = productDao.getByTitle(product.getTitle());
        int changedQuantity = updateProduct.getAmount() - amount;
        Orders updatedOrders = ordersDao.update(orders);
        updateProduct.setAmount(changedQuantity);
        productDao.update(updateProduct);
        return mapper.map(updatedOrders, OrderGetDto.class);
    }

    public Integer getSumOrder(Product product) {
        int allPrice = 0;
        int price;
        int number;
        number = product.getPurchaseQuantity();
        price = product.getPrice();
        allPrice = (number * price) + allPrice;


        return allPrice;
    }
}

