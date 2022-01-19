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

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public OrdersDto createOrders(@RequestBody OrdersDto ordersDto
            , @AuthenticationPrincipal UserDetails userDetails) {

        return ordersService.saveOrder(ordersDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        ordersService.deleteOrder(id);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public OrdersDto getById(@PathVariable Integer id, @AuthenticationPrincipal UserDetails userDetails) {
        return ordersService.getInfoOrder(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping
    public OrdersDto updateOrder(@RequestBody OrdersDto ordersDto) {
        return ordersService.updateOrder(ordersDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/{ordersDto}/{productDto}/{count}")
    public OrdersDto addProducts(
            @PathVariable Integer ordersDto
            , @PathVariable Integer productDto
            , @PathVariable Integer count,
            @AuthenticationPrincipal UserDetails userDetails) {
        return ordersService.addProducts(ordersDto, productDto, count);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/{ordersId}/{numberCard}")
    public OrdersDto addDiscountCard(@PathVariable Integer ordersId,
                                     @PathVariable String numberCard) {
        ordersService.addDiscountCard(ordersId, numberCard);
        return ordersService.getInfoOrder(ordersId);
    }

}
