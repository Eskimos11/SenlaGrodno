package com.senla.service;

import com.senla.api.dao.DetailsDao;
import com.senla.api.dao.DiscountCardDao;
import com.senla.controller.dto.DetailsDto;
import com.senla.controller.dto.DiscountCardDto.DiscountCardDto;
import com.senla.controller.dto.OrdersDto.OrdersDto;
import com.senla.controller.dto.UserDto.UserCreateDto;
import com.senla.controller.dto.UserDto.UserDto;
import com.senla.entity.*;
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
    private final DetailsDao detailsDao;
    private final ModelMapper mapper;

    public DiscountCardDto createDiscountCard(DiscountCardDto discountCardDto, DetailsDto detailsDto) {
        final DiscountCard discountCard = mapper.map(discountCardDto, DiscountCard.class);
        final Details details = mapper.map(detailsDto, Details.class);
        discountCard.setDetails(details);
        discountCard.setStatus(Status.valueOf("BRONZE"));
        detailsDao.save(details);
        final DiscountCard savedDiscountCard = discountCardDao.save(discountCard);
        return mapper.map(savedDiscountCard, DiscountCardDto.class);
    }

    public DiscountCardDto getUserDiscountCard(Integer id) {
        final DiscountCard discountCard = ofNullable(discountCardDao.getById(id))
                .orElseThrow(() -> new UserNotFoundException(id));
        return mapper.map(discountCard, DiscountCardDto.class);
    }
    public DiscountCardDto getDiscountCardByNumber(String number){
        DiscountCard discountCard = discountCardDao.getByNumber(number);
        return mapper.map(discountCard,DiscountCardDto.class);
    }

    public DiscountCardDto updateDiscountCard(DiscountCardDto discountCardDto) {
        final DiscountCard discountCard = mapper.map(discountCardDto, DiscountCard.class);
        final DiscountCard updatedCard = discountCardDao.update(discountCard);
        return mapper.map(updatedCard, DiscountCardDto.class);
    }

    public DiscountCard checkStatus(String number) {
        DiscountCard discountCard = discountCardDao.getByNumber(number);
        if (discountCard.getBalance() <= 25) {
            discountCard.setStatus(Status.valueOf("BRONZE"));
        } else if (discountCard.getBalance() <= 40) {
            discountCard.setStatus(Status.valueOf("SILVER"));
        } else if (discountCard.getBalance() > 40) {
            discountCard.setStatus(Status.valueOf("GOLD"));
        }
        return discountCardDao.update(discountCard);
    }
    public DiscountCard skidka(Orders orders,DiscountCard discountCard){
        if (discountCard.getStatus().equals(Status.BRONZE)){
            orders.setSum(orders.getSum()-3);
        } else if (discountCard.getStatus().equals(Status.SILVER)){
            orders.setSum(orders.getSum()-4);
        } else if (discountCard.getStatus().equals(Status.GOLD)){
            orders.setSum(orders.getSum()-4);
        }
        return discountCard;
    }
}

