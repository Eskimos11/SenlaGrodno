package com.senla.controller;

import com.senla.controller.dto.ProviderCreateDto;
import com.senla.controller.dto.ProviderDto;
import com.senla.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/providers")
public class ProviderController {

    private final ProviderService providerService;
    @PostMapping
    public ProviderDto createCustomer(@RequestBody ProviderCreateDto providerDto) {
        return providerService.saveProvider(providerDto);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        providerService.deleteProvider(id);
    }
    @GetMapping(value = "/{id}")
    public ProviderDto getById(@PathVariable Integer id) {
        return providerService.getProviderInfo(id);
    }
    @PutMapping
    public ProviderDto updateCustomer(@RequestBody ProviderDto providerDto) {
        return providerService.updateProvider(providerDto);

    }
}

