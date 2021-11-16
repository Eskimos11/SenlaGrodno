package com.senla.service;

import com.senla.annotation.Transactional;
import com.senla.api.dao.ProviderDao;
import com.senla.api.service.ProviderService;
import com.senla.entity.Provider;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderDao providerDao;

    public ProviderServiceImpl(ProviderDao providerDao) {
        this.providerDao = providerDao;
    }

    @Override
    @Transactional
    public void saveProvider(Provider provider) {
        providerDao.save(provider);
        System.out.println("Object created - " + provider);

    }

    @Override
    public void deleteProvider(Provider provider){
        providerDao.delete(provider);
        System.out.println("Object deleted");
    }

    @Override
    public Provider getProvider(Integer id){
       return providerDao.getById(id);
    }

    @Override
    public Provider updateProvider(Provider provider){
       return providerDao.update(provider);

    }
}
