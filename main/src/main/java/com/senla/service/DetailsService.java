package com.senla.service;

import com.senla.api.dao.DetailsDao;
import com.senla.controller.dto.DetailsDto;
import com.senla.entity.Details;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailsService {
    private final DetailsDao detailsDao;
    private final ModelMapper mapper;

    public DetailsDto getInfoDetails(Integer id) {
        final Details details =detailsDao.getById(id);
        return mapper.map(details, DetailsDto.class);
    }

}
