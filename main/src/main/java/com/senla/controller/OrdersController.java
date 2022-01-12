package com.senla.controller;

import com.senla.controller.dto.OrdersDto.OrderGetDto;
import com.senla.controller.dto.OrdersDto.OrdersDto;
import com.senla.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping
    @Secured("ROLE_USER")
    public OrdersDto createOrders(@RequestBody OrdersDto ordersDto) {
        return ordersService.saveOrder(ordersDto);
    }
    @Secured("ROLE_USER")
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        ordersService.deleteOrder(id);
    }
    @Secured("ROLE_USER")
    @GetMapping(value = "/{id}")
    public OrderGetDto getById(@PathVariable Integer id) {
        return ordersService.getInfoOrder(id);
    }
    @Secured("ROLE_ADMIN")
    @PutMapping
    public OrdersDto updateOrder(@RequestBody OrdersDto ordersDto) {
        return ordersService.updateOrder(ordersDto);
    }
    @Secured("ROLE_USER")
    @PutMapping("/{ordersDto}/{productDto}/{count}")
    public OrderGetDto addProducts(@PathVariable Integer ordersDto
            , @PathVariable Integer productDto
            , @PathVariable Integer count) {
        return ordersService.addProducts(ordersDto, productDto, count);
    }
}
