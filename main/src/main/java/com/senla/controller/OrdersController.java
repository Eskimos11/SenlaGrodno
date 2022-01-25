package com.senla.controller;

import com.senla.controller.dto.OrdersDto.OrdersDto;
import com.senla.service.OrdersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Log4j
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping
    public OrdersDto createOrders(@RequestBody OrdersDto ordersDto
            , @AuthenticationPrincipal Integer id) {
        return ordersService.createOrder(ordersDto,id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        ordersService.deleteOrder(id);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public OrdersDto getById(@PathVariable Integer id) {
        return ordersService.getInfoOrder(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PutMapping
    public OrdersDto updateOrder(@RequestBody OrdersDto ordersDto,
                                 @AuthenticationPrincipal Integer userId) {
        return ordersService.updateOrder(ordersDto,userId);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/{ordersDto}/{productDto}/{count}")
    public OrdersDto addProduct(
            @PathVariable Integer ordersDto
            , @PathVariable Integer productDto
            , @PathVariable Integer count,
            @AuthenticationPrincipal Integer userId) {
        return ordersService.addProducts(ordersDto, productDto, count,userId);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/{ordersId}/{numberCard}")
    public OrdersDto addDiscountCard(@PathVariable Integer ordersId,
                                     @PathVariable String numberCard,
                                     @AuthenticationPrincipal Integer userId) {
        ordersService.addDiscountCard(ordersId, numberCard,userId);
        return ordersService.getInfoOrder(ordersId);
    }

}
