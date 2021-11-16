package com.senla.controller;

import com.senla.api.service.ProviderService;
import com.senla.controller.mapper.JsonToModelMapper;
import com.senla.entity.Provider;
import org.springframework.stereotype.Component;

@Component
public class ProviderController {

    private final ProviderService providerService;
    private final JsonToModelMapper jsonToUserMapper;

    public ProviderController(ProviderService providerService, JsonToModelMapper jsonToUserMapper) {
        this.providerService = providerService;
        this.jsonToUserMapper = jsonToUserMapper;
    }

    public void createProvider(String providerJson) {
        Provider provider = jsonToUserMapper.convertToModel(providerJson);
        providerService.saveProvider(provider);
    }

    public void deleteProvider(String providerJson) {
        Provider provider = jsonToUserMapper.convertToModel(providerJson);
        providerService.deleteProvider(provider);
    }

    public Provider getProvider(Integer id) {
        return providerService.getProvider(id);
    }

    public Provider updateProvider(String providerJson){
        Provider provider = jsonToUserMapper.convertToModel(providerJson);
        providerService.updateProvider(provider);
        return provider;
    }
}

