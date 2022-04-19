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
    @GetMapping(value = "id/{id}")
    public DiscountCardDto getById(@PathVariable Long id) {
        return discountCardService.getDiscountCard(id);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/{number}")
    public DiscountCardDto createDiscountCard(@PathVariable String number){
        return discountCardService.createDiscountCard(number);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/number/{number}")
    public DiscountCardDto getDiscountCardByNumber(@PathVariable String number){
        return discountCardService.getDiscountCardByNumber(number);
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/remove/{number}")
    public void deleteDiscountCardByNumber(@PathVariable String number){
        discountCardService.deleteDiscountCard(number);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/")
    public DiscountCardDto updateDiscountCard(@RequestBody DiscountCardDto discountCardDto){
        return discountCardService.updateDiscountCard(discountCardDto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/add_details/{number}")
    public void addDetails(@PathVariable String number,
                           @RequestBody DetailsDto detailsDto){
         discountCardService.addDetails(number,detailsDto);
    }

}

