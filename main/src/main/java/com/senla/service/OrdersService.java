package com.senla.service;

import com.senla.api.dao.OrdersDao;
import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.OrdersDto;
import com.senla.entity.Orders;
import com.senla.entity.Product;
import com.senla.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public OrdersDto getInfoOrder(Integer id) {
        final Orders orders = ofNullable(ordersDao.getById(id))
                .orElseThrow(() -> new OrderNotFoundException(id));
        return mapper.map(orders, OrdersDto.class);
    }

    public OrdersDto updateOrder(OrdersDto ordersDto) {
        final Orders orders = mapper.map(ordersDto, Orders.class);
        final Orders updatedOrders = ordersDao.update(orders);
        return mapper.map(updatedOrders, OrdersDto.class);
    }

    public OrdersDto addProducts(int ordersDto, int productDto, int count) {
//        Orders orders = mapper.map(ordersDto,Orders.class);
//        Product product = mapper.map(productDto,Product.class);
        Orders orders = ordersDao.getById(ordersDto);
        Product product = productDao.getById(productDto);

        List<Product> productListOrders = orders.getProductList();
        product.setNumber(count);
        productListOrders.add(product);
        orders.setProductList(productListOrders);
        orders.setSum(getSumOrder(orders));
        Product product1 = productDao.getByTitle(product.getTitle());
        int a = product1.getNumber() - count;
        Orders updatedOrders = ordersDao.update(orders);
        product1.setNumber(a);
        productDao.update(product1);
        return mapper.map(updatedOrders, OrdersDto.class);
//        mapper.map(updateProduct,ProductDto.class);

//        return updatedOrders;
    }

    public Integer getSumOrder(Orders orders) {
        int allPrice = 0;
        int price;
        int number;
        for (Product product : orders.getProductList()) {
            number = product.getNumber();
//            if (number >= 1) {
            price = product.getPrice();
            allPrice = (number * price) + allPrice;


        }
        return allPrice;
    }
}

