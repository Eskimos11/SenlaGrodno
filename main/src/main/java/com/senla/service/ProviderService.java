package com.senla.service;

import com.senla.api.dao.ProviderDao;
import com.senla.controller.dto.ProviderCreateDto;
import com.senla.controller.dto.ProviderDto;
import com.senla.entity.Provider;
import com.senla.exception.ProviderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class ProviderService  {

    private final ProviderDao providerDao;
    private final ModelMapper mapper;


    public ProviderDto saveProvider(ProviderCreateDto providerDto) {
        final Provider provider = mapper.map(providerDto,Provider.class);
        final Provider savedProvider = providerDao.save(provider);
        return mapper.map(savedProvider,ProviderDto.class);

    }

    public void deleteProvider(Integer id) {
        providerDao.deleteById(id);
    }


    public ProviderDto getProviderInfo(Integer id) {
        final Provider provider = ofNullable(providerDao.getById(id))
                .orElseThrow(() -> new ProviderNotFoundException(id));
        return mapper.map(provider,ProviderDto.class);
    }


    public ProviderDto updateProvider(ProviderDto providerDto) {
        final Provider provider = mapper.map(providerDto,Provider.class);
        final Provider updatedProvider = providerDao.update(provider);
        return mapper.map(updatedProvider,ProviderDto.class);

    }
}

