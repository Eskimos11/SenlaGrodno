package com.senla.service;

import com.senla.api.dao.DiscountCardDao;
import com.senla.controller.dto.DiscountCardDto.DiscountCardDto;
import com.senla.controller.dto.OrdersDto.OrdersDto;
import com.senla.controller.dto.UserDto.UserCreateDto;
import com.senla.entity.DiscountCard;
import com.senla.entity.Orders;
import com.senla.entity.User;
import com.senla.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
@Log4j
public class DiscountCardService {

    private final DiscountCardDao discountCardDao;
    private final ModelMapper mapper;

    public DiscountCardDto createDiscountCard(DiscountCardDto discountCardDto){
        final DiscountCard discountCard = mapper.map(discountCardDto, DiscountCard.class);
        final DiscountCard savedDiscountCard = discountCardDao.save(discountCard);
        return mapper.map(savedDiscountCard, DiscountCardDto.class);
    }
    public DiscountCardDto getUserDiscountCard(Integer id) {
        final DiscountCard discountCard = ofNullable(discountCardDao.getById(id))
                .orElseThrow(() -> new UserNotFoundException(id));
        return mapper.map(discountCard, DiscountCardDto.class);
    }


}
