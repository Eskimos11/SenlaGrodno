package com.senla.controller;

import com.Autowire;
import com.Singleton;
import com.Value;
import com.senla.api.IFacade;
import com.senla.api.service.IProviderService;
import com.senla.entity.Provider;
@Singleton
public class Facade implements IFacade {

    @Autowire
    private IProviderService providerService;
    @Value("controller")
    private String str;
    @Override
    public Provider createProvider(String title) {
        providerService.doo();
        return providerService.createProvider(title);

    }
}
