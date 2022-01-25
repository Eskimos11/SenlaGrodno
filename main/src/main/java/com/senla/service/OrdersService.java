package com.senla.service;

import com.senla.api.dao.DiscountCardDao;
import com.senla.api.dao.OrdersDao;
import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.OrdersDto.OrdersDto;
import com.senla.entity.DiscountCard;
import com.senla.entity.Orders;
import com.senla.entity.Product;
import com.senla.exception.DiscountCardFoundException;
import com.senla.exception.NoAccessRightsException;
import com.senla.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
@Log4j
public class OrdersService {
    private final OrdersDao ordersDao;
    private final ProductDao productDao;
    private final DiscountCardDao discountCardDao;
    private final DiscountCardService discountCardService;
    private final ModelMapper mapper;

    public OrdersDto createOrder(OrdersDto ordersDto, Integer id) {
        final Orders orders = mapper.map(ordersDto, Orders.class);
        orders.setUserId(id);
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

    public OrdersDto updateOrder(OrdersDto ordersDto, Integer id) {
        final Orders orders = mapper.map(ordersDto, Orders.class);
        if (!orders.getUserId().equals(id))
            throw new NoAccessRightsException("");
        final Orders updatedOrders = ordersDao.update(orders);
        return mapper.map(updatedOrders, OrdersDto.class);
    }

    @Transactional
    public OrdersDto addProducts(Integer orderId, Integer productId, Integer amount, Integer id) {
        Orders orders = ordersDao.getById(orderId);
        if (!orders.getUserId().equals(id))
            throw new NoAccessRightsException("");
        Product product = productDao.getById(productId);
        List<Product> productListOrders = productDao.getProduct(orderId);
        product.setPurchaseQuantity(amount);
        productListOrders.add(product);
        orders.setProductList(productListOrders);
        orders.setSum(getSumOrder(product) + orders.getSum());
        Product updateProduct = productDao.getByTitle(product.getTitle());
        int changedQuantity = updateProduct.getAmount() - amount;
        Orders updatedOrders = ordersDao.update(orders);
        updateProduct.setAmount(changedQuantity);
        productDao.update(updateProduct);
        return mapper.map(updatedOrders, OrdersDto.class);
    }


    private Integer getSumOrder(Product product) {
        int totalAmount = 0;
        int price;
        int number;
        number = product.getPurchaseQuantity();
        price = product.getPrice();
        totalAmount = (number * price) + totalAmount;
        return totalAmount;
    }

    @Transactional
    public OrdersDto addDiscountCard(Integer orderId, String numberCard, Integer id) {
        Orders orders = ordersDao.getById(orderId);
        if (!orders.getUserId().equals(id))
            throw new NoAccessRightsException("");
        if (orders.getDiscountCard() == null) {
            orders.setDiscountCard(discountCardDao.getByNumber(numberCard));
            discountCardService.checkStatus(numberCard);
            DiscountCard discountCard = discountCardDao.getByNumber(numberCard);
            discountCard.setBalance(discountCard.getBalance() + orders.getSum());
            discountCardService.giveDiscount(orders, discountCardDao.getByNumber(numberCard));
            discountCardDao.update(discountCard);
        } else throw new DiscountCardFoundException("Карта введена");

        Orders updateOrders = ordersDao.update(orders);
        return mapper.map(updateOrders, OrdersDto.class);
    }
}

