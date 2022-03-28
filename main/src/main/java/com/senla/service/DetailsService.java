package com.senla.service;

import com.senla.api.dao.DetailsDao;
import com.senla.controller.dto.DetailsDto;
import com.senla.entity.Details;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
//@Log4j
public class DetailsService {

    private final DetailsDao detailsDao;
    private final ModelMapper mapper;
    @Transactional
    public DetailsDto getInfoDetails(Long id) {
        final Details details = detailsDao.getById(id);
        return mapper.map(details, DetailsDto.class);
    }

}
