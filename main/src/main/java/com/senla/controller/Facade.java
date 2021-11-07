package com.senla.controller;

import com.Autowire;
import com.Singleton;
import com.Value;
import com.senla.api.service.ProviderService;
import com.senla.entity.Provider;
@Singleton
public class Facade implements com.senla.api.Facade {

    @Autowire
    private ProviderService providerService;
    @Value("controller")
    private String str;
    @Override
    public Provider createProvider(String title) {
        providerService.doo();
        return providerService.createProvider(title);

    }
}
