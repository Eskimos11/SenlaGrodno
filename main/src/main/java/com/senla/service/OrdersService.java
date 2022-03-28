package com.senla.service;

import com.senla.api.dao.DiscountCardDao;
import com.senla.api.dao.OrdersDao;
import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.OrdersDto.OrdersDto;
import com.senla.controller.dto.ProductDto.ProductDto;
import com.senla.entity.DiscountCard;
import com.senla.entity.Orders;
import com.senla.entity.Product;
import com.senla.exception.DiscountCardFoundException;
import com.senla.exception.NoAccessRightsException;
import com.senla.exception.OrderNotFoundException;
import com.senla.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
//@Log4j
public class OrdersService {
    private final OrdersDao ordersDao;
    private final ProductDao productDao;
    private final DiscountCardDao discountCardDao;
    private final DiscountCardService discountCardService;
    private final ModelMapper mapper;
    @Transactional
    public OrdersDto createOrder(OrdersDto ordersDto, Long userId) {
        final Orders orders = mapper.map(ordersDto, Orders.class);
        orders.setUserId(userId);
        final Orders savedOrders = ordersDao.save(orders);
        return mapper.map(savedOrders, OrdersDto.class);
    }
    @Transactional
    public void deleteOrder(Long id) {
        ordersDao.deleteById(id);
    }
    @Transactional
    public OrdersDto getInfoOrder(Long id) {
        final Orders orders = ofNullable(ordersDao.getById(id))
                .orElseThrow(() -> new OrderNotFoundException(id));

        return mapper.map(orders, OrdersDto.class);
    }
    @Transactional
    public OrdersDto updateOrder(OrdersDto ordersDto, Integer id) {
        final Orders orders = mapper.map(ordersDto, Orders.class);
        if (!orders.getUserId().equals(id))
            throw new NoAccessRightsException("");
        final Orders updatedOrders = ordersDao.update(orders);
        return mapper.map(updatedOrders, OrdersDto.class);
    }

    @Transactional
    public OrdersDto addProducts(Long orderId, Long productId, Integer amount, Long id) {
        Orders orders = ordersDao.getById(orderId);
        if (!orders.getUserId().equals(id))
            throw new NoAccessRightsException("");
        Product product = ofNullable(productDao.getById(productId))
                .orElseThrow(() -> new ProductNotFoundException(id));
        List<Product> productListOrders = ordersDao.getProductFromOrder(orderId);
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
    public OrdersDto addDiscountCard(Long orderId, String numberCard, Long id) {
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
    @Transactional
    public List<ProductDto> getProductOrders(Long id) {
        List<Product> productList = ordersDao.getProductFromOrder(id);
        return productList
                .stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }
}

