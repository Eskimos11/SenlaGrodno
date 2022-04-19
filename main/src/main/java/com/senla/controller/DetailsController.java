package com.senla.controller;

import com.senla.controller.dto.DetailsDto;
import com.senla.service.DetailsService;
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
    public DetailsDto getById(@PathVariable Long id) {
        return detailsService.getInfoDetails(id);
    }
}
