package com.senla.service;

import com.Autowire;
import com.Singleton;
import com.Value;
import com.senla.api.dao.IProviderDao;

import com.senla.api.service.IProviderService;
import com.senla.entity.Provider;

@Singleton
public class ProviderService  implements IProviderService {

    @Autowire
    private IProviderDao providerDao;

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
