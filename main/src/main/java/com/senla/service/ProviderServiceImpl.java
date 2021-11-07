package com.senla.service;

import com.Autowire;
import com.Singleton;
import com.Value;
import com.senla.api.dao.ProviderDao;

import com.senla.entity.Provider;

@Singleton
public class ProviderServiceImpl implements com.senla.api.service.ProviderService {

    @Autowire
    private ProviderDao providerDao;

    @Value("service")
    private String string;

    @Override
    public Provider createProvider(String title) {
        Provider provider = new Provider(title);
        providerDao.save(provider);
        providerDao.doo();
        return provider;
    }

    @Override
    public void doo() {
        System.out.println(string);
    }

}
