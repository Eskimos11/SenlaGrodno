package com.senla.controller;

import com.senla.controller.dto.DetailsDto;
import com.senla.controller.dto.UserDto.UserCreateDto;
import com.senla.service.DetailsService;
import com.senla.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/details")
public class DetailsController {

    private final DetailsService detailsService;

    @GetMapping(value = "/{id}")
    public DetailsDto getById(@PathVariable Integer id) {
        return detailsService.getInfoDetails(id);
    }
}
