package com.senla.controller;

import com.senla.controller.dto.OrdersDto;
import com.senla.controller.dto.ProductDto;
import com.senla.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;
    @PostMapping
    public OrdersDto createOrders(@RequestBody OrdersDto ordersDto) {
        return ordersService.saveOrder(ordersDto);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        ordersService.deleteOrder(id);
    }
    @GetMapping(value = "/{id}")
    public OrdersDto getById(@PathVariable Integer id) {
        return ordersService.getInfoOrder(id);
    }
    @PutMapping
    public OrdersDto updateOrder(@RequestBody OrdersDto ordersDto) {
        return ordersService.updateOrder(ordersDto);
    }

    @GetMapping("/add/{orderId}/{productId}/{count}")
    public OrdersDto addProducts(@PathVariable Integer orderId
                                ,@PathVariable Integer productId
                                ,@PathVariable Integer count) {
        return ordersService.addProducts(orderId,productId,count);
    }
}
