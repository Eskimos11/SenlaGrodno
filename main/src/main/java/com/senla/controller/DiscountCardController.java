package com.senla.controller;


import com.senla.controller.dto.DetailsDto;
import com.senla.controller.dto.DiscountCardDto.DiscountCardDto;

import com.senla.service.DiscountCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class DiscountCardController {
    private final DiscountCardService discountCardService;
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/{id}")
    public DiscountCardDto getById(@PathVariable Integer id) {
        return discountCardService.getUserDiscountCard(id);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public DiscountCardDto createDiscountCard(@RequestBody DiscountCardDto discountCardDto,
                                              @RequestBody DetailsDto detailsDto) {
        return discountCardService.createDiscountCard(discountCardDto,detailsDto);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{number}")
    public DiscountCardDto getDiscountCardByNumber(@PathVariable String number){
        return discountCardService.getDiscountCardByNumber(number);
    }

}
