package com.senla.service;

import com.senla.api.dao.ProviderDao;

import com.senla.controller.dto.ProviderCreateDto;
import com.senla.controller.dto.ProviderDto;
import com.senla.entity.Provider;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProviderServiceTest {

    @InjectMocks
    private ProviderService providerService;
    @Spy
    private ModelMapper mapper;


    @Mock
    private ProviderDao providerDao;

    @Test
    public void saveProviderShouldFinishOk() {

        final String title = "Pepsi";
        when(providerDao.save(any())).thenReturn(Provider.builder().title(title).id(123).build());

        final ProviderDto userDto = providerService.saveProvider(
                ProviderCreateDto.builder()
                        .title(title)
                        .build());

        assertEquals(123, userDto.getId());
        assertEquals(title, userDto.getTitle());
    }
    @Test
    public void deleteProviderShouldFinishOk() {

        String title = "Pepsi";
        when(providerDao.save(any())).thenReturn(Provider.builder().title(title).id(123).build());

        final ProviderDto userDto = providerService.saveProvider(
                ProviderCreateDto.builder()
                        .title(title)
                        .build());
        providerService.deleteProvider(userDto.getId());
        assertEquals(null, providerDao.getById(userDto.getId()));
    }


}