package com.senla.service;

import com.senla.api.dao.ProviderDao;

import com.senla.controller.dto.ProviderCreateDto;
import com.senla.controller.dto.ProviderDto;
import com.senla.entity.Provider;
import com.senla.converter.ProviderConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProviderServiceTest {

    @InjectMocks
    private ProviderServiceImpl providerService;

    @Spy
    private ProviderConverter providerConverter;

    @Mock
    private ProviderDao providerDao;

    @Test
    public void saveUserShouldFinishOk() {

        final String title = "Pepsi";
        when(providerDao.save(any())).thenReturn(Provider.builder().title(title).id(123).build());

        final ProviderDto providerDto = providerService.saveProvider(
                ProviderCreateDto.builder()
                        .title(title)
                       .build());

        assertEquals(123, providerDto.getId());
        assertEquals(title, providerDto.getTitle());
    }


}