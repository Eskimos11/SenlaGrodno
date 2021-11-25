package com.senla.service;

import com.senla.api.dao.ProviderDao;
import com.senla.api.service.ProviderService;
import com.senla.controller.dto.ProviderDto;
import com.senla.entity.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderDao providerDao;

    @Override
    @Transactional
    public void saveProvider(ProviderDto providerDto) {
        final Provider provider = Provider.builder()
                .title(providerDto.getTitle()).build();
        providerDao.save(provider);

    }

    @Override
    @Transactional
    public void deleteProvider(Integer id) {
        providerDao.delete(id);
    }

    @Override
    @Transactional
    public Provider getProvider(Integer id) {
        return providerDao.getById(id);
    }

    @Override
    @Transactional
    public Provider updateProvider(ProviderDto providerDto) {
        final Provider provider = Provider.builder()
                .title(providerDto.getTitle()).build();
        return providerDao.update(provider);

    }
}
