package com.senla.api.service;

import com.senla.entity.Provider;

public interface ProviderService {

    void saveProvider(Provider provider);

    void deleteProvider(Provider provider);

    Provider getProvider(Integer id);

    Provider updateProvider(Integer id, Provider provider);
}
