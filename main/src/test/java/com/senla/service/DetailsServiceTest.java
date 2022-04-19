package com.senla.service;

import com.senla.api.dao.DetailsDao;
import com.senla.entity.Details;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Rollback(value = false)
class DetailsServiceTest {
    @Mock
    private DetailsDao detailsDao;
    @Spy
    private ModelMapper mapper;
    @InjectMocks
    private DetailsService detailsService;
    @Test
    void getInfoDetails() {
        when(detailsDao.getById(any())).thenReturn(Details.builder().id(123L)
                .firstName("Pavel").build());
        Details details = Details.builder().id(123L)
                .firstName("Pavel").build();
        assertNotNull(detailsService.getInfoDetails(details.getId()));
    }
}