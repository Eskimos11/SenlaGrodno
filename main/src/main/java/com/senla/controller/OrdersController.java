package com.senla.controller;

import com.senla.controller.dto.OrdersDto.OrderGetDto;
import com.senla.controller.dto.OrdersDto.OrdersDto;
import com.senla.entity.User;
import com.senla.security.JwtAuthenticationFilter;
import com.senla.security.UserDetailServiceImpl;
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
    @RequestMapping(value = "",method = RequestMethod.POST)
    public OrdersDto createOrders(@AuthenticationPrincipal User user,
                                  @RequestBody OrdersDto ordersDto) {

        return ordersService.saveOrder(ordersDto);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        ordersService.deleteOrder(id);
    }
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public OrderGetDto getById(@AuthenticationPrincipal User user, @PathVariable Integer id) {
        return ordersService.getInfoOrder(id);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping
    public OrdersDto updateOrder(@RequestBody OrdersDto ordersDto) {
        return ordersService.updateOrder(ordersDto);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/{ordersDto}/{productDto}/{count}")
    public OrderGetDto addProducts(
              @PathVariable Integer ordersDto
            , @PathVariable Integer productDto
            , @PathVariable Integer count,
              @AuthenticationPrincipal UserDetails userDetails)
            {
        return ordersService.addProducts(ordersDto, productDto, count);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{ordersId}/{productId}",method = RequestMethod.PUT)
    public void removeProductFromOrder(@AuthenticationPrincipal UserDetails userDetails
            , @PathVariable Integer ordersId
            , @PathVariable Integer productId){
        ordersService.removeProductFromOrder(ordersId, productId);
    }
}
