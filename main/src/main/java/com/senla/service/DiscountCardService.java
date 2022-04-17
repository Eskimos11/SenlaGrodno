package com.senla.service;

import com.senla.api.dao.DetailsDao;
import com.senla.api.dao.DiscountCardDao;
import com.senla.controller.dto.DetailsDto;
import com.senla.controller.dto.DiscountCardDto.DiscountCardDto;
import com.senla.entity.Details;
import com.senla.entity.DiscountCard;
import com.senla.entity.Orders;
import com.senla.entity.Status;
import com.senla.exception.CardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
//@Log4j
public class DiscountCardService {

    private final DiscountCardDao discountCardDao;
    private final DetailsDao detailsDao;
    private final ModelMapper mapper;

    @Transactional
    public DiscountCardDto createDiscountCard(String number) {
        DiscountCard discountCard = new DiscountCard();
        discountCard.setNumber(number);
        discountCard.setBalance(0);
        discountCard.setStatus(Status.valueOf("BRONZE"));
        final DiscountCard savedDiscountCard = discountCardDao.save(discountCard);
        return mapper.map(savedDiscountCard, DiscountCardDto.class);
    }

    @Transactional
    public DiscountCardDto addDetails(String number,DetailsDto detailsDto){
        final Details details = mapper.map(detailsDto,Details.class);
        DiscountCard discountCard = discountCardDao.getByNumber(number);
        discountCard.setDetails(details);
        detailsDao.save(details);
        final DiscountCard savedDiscountCard = discountCardDao.update(discountCard);
        return mapper.map(savedDiscountCard,DiscountCardDto.class);

    }
    @Transactional
    public DiscountCardDto getDiscountCard(Long id) {
        final DiscountCard discountCard = ofNullable(discountCardDao.getById(id))
                .orElseThrow(() -> new CardNotFoundException(id));
        return mapper.map(discountCard, DiscountCardDto.class);
    }
    @Transactional
    public DiscountCardDto getDiscountCardByNumber(String number) {
        DiscountCard discountCard = ofNullable(discountCardDao.getByNumber(number))
                .orElseThrow(NoResultException::new);
        return mapper.map(discountCard, DiscountCardDto.class);
    }
    @Transactional
    public DiscountCardDto updateDiscountCard(DiscountCardDto discountCardDto) {
        final DiscountCard discountCard = mapper.map(discountCardDto, DiscountCard.class);
        final DiscountCard updatedCard = discountCardDao.update(discountCard);
        return mapper.map(updatedCard, DiscountCardDto.class);
    }
    @Transactional
    public void deleteDiscountCard(String number) {
        DiscountCard discountCard = discountCardDao.getByNumber(number);
        discountCardDao.deleteById(discountCard.getId());
    }

    public DiscountCard changeStatus(String number) {
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


    }


