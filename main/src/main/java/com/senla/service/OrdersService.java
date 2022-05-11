package com.senla.service;

import com.senla.api.dao.DiscountCardDao;
import com.senla.api.dao.OrdersDao;
import com.senla.api.dao.ProductAmountDao;
import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.OrdersDto.OrdersDto;
import com.senla.controller.dto.ProductDto.ProductDto;
import com.senla.entity.*;
import com.senla.exception.DiscountCardFoundException;
import com.senla.exception.NoAccessRightsException;
import com.senla.exception.OrderNotFoundException;
import com.senla.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
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
    private final ProductAmountDao productAmountDao;
    private final ProductAmountService productAmountService;
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
        return mapper.map(ordersDao.update(orders), OrdersDto.class);
    }

    @Transactional
    public OrdersDto addProducts(Long orderId, Long productId, Integer amount) {
        Orders orders = ordersDao.getById(orderId);
        if(orders.isStatusOrder()){
            throw new OrderNotFoundException(orderId);
        }
//        if (!orders.getUserId().equals(id))
//            throw new NoAccessRightsException("");
        Product product = ofNullable(productDao.getById(productId))
                .orElseThrow(() -> new ProductNotFoundException(productId));
        List<Product> productListOrders = ordersDao.getProductFromOrder(orderId);
        productListOrders.add(product);
        orders.setProductList(productListOrders);
        orders.setSum(getSumOrder(product, amount) + orders.getSum());
        product.setAmount(product.getAmount() - amount);
        ProductAmount productAmount = productAmountService.createProductAmount(orders,product,amount);
        productAmountDao.save(productAmount);
        productDao.update(product);
        return mapper.map(ordersDao.update(orders), OrdersDto.class);
    }
    public OrdersDto closeOrder(Long orderId){
        Orders order = ordersDao.getById(orderId);
        order.setStatusOrder(false);
        return mapper.map(ordersDao.update(order),OrdersDto.class);
    }


    private Integer getSumOrder(Product product, Integer amount) {
        return product.getPrice() * amount;
    }

    @Transactional
    public OrdersDto addDiscountCardToOrder(Long orderId, String numberCard, Long userId) {
        Orders orders = ordersDao.getById(orderId);
        if (!orders.getUserId().equals(userId))
            throw new NoAccessRightsException("");
        if (orders.getDiscountCard() == null) {
            orders.setDiscountCard(discountCardDao.getByNumber(numberCard));
            discountCardService.changeStatus(numberCard);
            DiscountCard discountCard = discountCardDao.getByNumber(numberCard);
            discountCard.setBalance(discountCard.getBalance() + orders.getSum());
            giveDiscount(orders, discountCardDao.getByNumber(numberCard));
            discountCardDao.update(discountCard);
        } else throw new DiscountCardFoundException("Карта введена");
        return mapper.map(ordersDao.update(orders), OrdersDto.class);
    }

    @Transactional
    public List<ProductDto> getProductOrders(Long id) {
        List<Product> productList = ordersDao.getProductFromOrder(id);
        return productList
                .stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public DiscountCard giveDiscount(Orders orders, DiscountCard discountCard) {
        if (discountCard.getStatus().equals(Status.BRONZE)) {
            orders.setSum(orders.getSum() - 3);
        } else if (discountCard.getStatus().equals(Status.SILVER)) {
            orders.setSum(orders.getSum() - 4);
        } else if (discountCard.getStatus().equals(Status.GOLD)) {
            orders.setSum(orders.getSum() - 5);
        }
        return discountCard;
    }
}

