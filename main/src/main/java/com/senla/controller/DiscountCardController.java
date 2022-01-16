package com.senla.controller;


import com.senla.controller.dto.DiscountCardDto.DiscountCardDto;

import com.senla.service.DiscountCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discountCard")
public class DiscountCardController {
    private final DiscountCardService discountCardService;

    @GetMapping(value = "/{id}")
    public DiscountCardDto getById(@PathVariable Integer id) {
        return discountCardService.getUserDiscountCard(id);
    }

    @PostMapping
    public DiscountCardDto createDiscountCard(@RequestBody DiscountCardDto discountCardDto) {
        return discountCardService.createDiscountCard(discountCardDto);
    }
}

