package com.senla.service;

import com.senla.api.dao.DetailsDao;
import com.senla.api.dao.DiscountCardDao;
import com.senla.api.dao.OrdersDao;
import com.senla.controller.dto.DetailsDto;
import com.senla.controller.dto.DiscountCardDto.DiscountCardDto;
import com.senla.entity.Details;
import com.senla.entity.DiscountCard;
import com.senla.entity.Orders;
import com.senla.entity.Status;
import com.senla.exception.CardNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
@Log4j
public class DiscountCardService {

    private final DiscountCardDao discountCardDao;
    private final OrdersDao ordersDao;
    private final DetailsDao detailsDao;
    private final ModelMapper mapper;

    public DiscountCardDto createDiscountCard(String number, DetailsDto detailsDto) {
        final Details details = mapper.map(detailsDto, Details.class);
        DiscountCard discountCard = new DiscountCard();
        discountCard.setNumber(number);
        discountCard.setDetails(details);
        discountCard.setBalance(0);
        discountCard.setStatus(Status.valueOf("BRONZE"));
        detailsDao.save(details);
        final DiscountCard savedDiscountCard = discountCardDao.update(discountCard);
        return mapper.map(savedDiscountCard, DiscountCardDto.class);
    }

    public DiscountCardDto getDiscountCard(Integer id) {
        final DiscountCard discountCard = ofNullable(discountCardDao.getById(id))
                .orElseThrow(() -> new CardNotFoundException(id));
        return mapper.map(discountCard, DiscountCardDto.class);
    }

    public DiscountCardDto getDiscountCardByNumber(String number) {
        DiscountCard discountCard = ofNullable(discountCardDao.getByNumber(number))
                .orElseThrow(() -> new NoResultException());
        return mapper.map(discountCard, DiscountCardDto.class);
    }

    public DiscountCardDto updateDiscountCard(DiscountCardDto discountCardDto) {
        final DiscountCard discountCard = mapper.map(discountCardDto, DiscountCard.class);
        final DiscountCard updatedCard = discountCardDao.update(discountCard);
        return mapper.map(updatedCard, DiscountCardDto.class);
    }

    public void deleteDiscountCard(String number) {
        DiscountCard discountCard = discountCardDao.getByNumber(number);
        discountCardDao.deleteById(discountCard.getId());
    }

    public DiscountCard checkStatus(String number) {
        DiscountCard discountCard = discountCardDao.getByNumber(number);
        if (discountCard.getBalance() <= 25) {
            discountCard.setStatus(Status.valueOf("BRONZE"));
        } else if (discountCard.getBalance() >= 26 && discountCard.getBalance() < 59) {
            discountCard.setStatus(Status.valueOf("SILVER"));
        } else if (discountCard.getBalance() > 60) {
            discountCard.setStatus(Status.valueOf("GOLD"));
        }
        return discountCardDao.update(discountCard);
    }

    public DiscountCard giveDiscount(Orders orders, DiscountCard discountCard) {
        if (discountCard.getStatus().equals(Status.BRONZE)) {
            orders.setSum(orders.getSum() - 3);
        } else if (discountCard.getStatus().equals(Status.SILVER)) {
            orders.setSum(orders.getSum() - 4);
        } else if (discountCard.getStatus().equals(Status.GOLD)) {
            orders.setSum(orders.getSum() - 5);
        }
        return discountCard;
    }
}

