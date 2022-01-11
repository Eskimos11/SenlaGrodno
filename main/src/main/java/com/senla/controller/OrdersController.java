package com.senla.controller;

import com.senla.controller.dto.OrdersDto.OrderGetDto;
import com.senla.controller.dto.OrdersDto.OrdersDto;
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
    public OrderGetDto getById(@PathVariable Integer id) {
        return ordersService.getInfoOrder(id);
    }

    @PutMapping
    public OrdersDto updateOrder(@RequestBody OrdersDto ordersDto) {
        return ordersService.updateOrder(ordersDto);
    }

    @PutMapping("/{ordersDto}/{productDto}/{count}")
    public OrderGetDto addProducts(@PathVariable Integer ordersDto
            , @PathVariable Integer productDto
            , @PathVariable Integer count) {
        return ordersService.addProducts(ordersDto, productDto, count);
    }
}
