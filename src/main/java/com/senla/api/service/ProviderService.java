package com.senla.api.service;

import com.senla.controller.dto.ProviderDto;
import com.senla.entity.Provider;

public interface ProviderService {

    void saveProvider(ProviderDto providerDto);

    void deleteProvider(Integer id);

    Provider getProvider(Integer id);

    Provider updateProvider(ProviderDto provider);
}
