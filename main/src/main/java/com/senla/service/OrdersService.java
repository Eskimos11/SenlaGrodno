package com.senla.service;

import com.senla.api.dao.OrdersDao;
import com.senla.controller.dto.OrdersDto;
import com.senla.controller.dto.ProductDto;
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
    private final ModelMapper mapper;

    public OrdersDto saveOrder(OrdersDto ordersDto) {
        final Orders orders = mapper.map(ordersDto, Orders.class);
//        orders.setSum(getSumOrder(orders));
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
        final Orders orders = mapper.map(ordersDao, Orders.class);
        final Orders updatedOrders = ordersDao.update(orders);
        return mapper.map(updatedOrders, OrdersDto.class);
    }
    public OrdersDto addProducts(OrdersDto ordersDto,ProductDto productDto){
        final Product product = mapper.map(productDto,Product.class);
        final Orders orders = mapper.map(ordersDto, Orders.class);
        List<Product> products = orders.getProductList();
        products.add(product);
        orders.setProductList(products);
        final Orders updatedOrders = ordersDao.update(orders);
        return mapper.map(updatedOrders, OrdersDto.class);
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

