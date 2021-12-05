package com.senla.service;

import com.senla.api.dao.ProviderDao;
import com.senla.controller.dto.ProviderCreateDto;
import com.senla.controller.dto.ProviderDto;
import com.senla.entity.Provider;
import com.senla.exception.ProviderNotFoundException;
import com.senla.converter.ProviderConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl  {

    private final ProviderDao providerDao;
    private final ProviderConverter providerConverter;


    public ProviderDto saveProvider(ProviderCreateDto providerDto) {
        final Provider provider = providerConverter.convert(providerDto);
        final Provider savedProvider = providerDao.save(provider);
        return providerConverter.convert(savedProvider);

    }

    public void deleteProvider(Integer id) {
        providerDao.deleteById(id);
    }


    public ProviderDto getProviderInfo(Integer id) {
        final Provider provider = ofNullable(providerDao.getById(id))
                .orElseThrow(() -> new ProviderNotFoundException(id));
        return providerConverter.convert(provider);
    }


    public ProviderDto updateProvider(ProviderDto providerDto) {
        final Provider provider = providerConverter.convert(providerDto);
        final Provider updatedProvider = providerDao.update(provider);
        return providerConverter.convert(updatedProvider);

    }
}

