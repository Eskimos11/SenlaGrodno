package com.senla.converter;

import com.senla.controller.dto.CustomerDto;
import com.senla.controller.dto.ProviderCreateDto;
import com.senla.controller.dto.ProviderDto;
import com.senla.entity.Customer;
import com.senla.entity.Provider;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    public Provider convert(ProviderCreateDto providerCreateDto) {
        return Provider.builder()
                .title(providerCreateDto.getTitle())
                .build();
    }

    public Provider convert(ProviderDto providerDto) {
        return Provider.builder()
                .title(providerDto.getTitle())
                .build();
    }


    public ProviderDto convert(Provider provider) {
        return ProviderDto.builder()
                .id(provider.getId())
                .title(provider.getTitle())
                .build();
    }

}
