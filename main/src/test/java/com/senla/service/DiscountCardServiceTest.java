package com.senla.service;

import com.senla.api.dao.DetailsDao;
import com.senla.api.dao.DiscountCardDao;
import com.senla.controller.dto.DetailsDto;
import com.senla.controller.dto.DiscountCardDto.DiscountCardDto;
import com.senla.entity.*;
import org.junit.jupiter.api.BeforeEach;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Rollback(value = false)
class DiscountCardServiceTest {
    @InjectMocks
    private DiscountCardService discountCardService;
    @Spy
    private ModelMapper mapper;
    @Mock
    private DiscountCardDao discountCardDao;
    @Mock
    private DetailsDao detailsDao;

    public DiscountCardDto discountCardDto;

    @BeforeEach
    public void init(){
        discountCardDto = DiscountCardDto.builder().id(1L).balance(123).number("1111").status(Status.BRONZE).build();
    }
    @Test
    void createDiscountCard() {
        when(discountCardDao.save(any()))
                .thenReturn(DiscountCard.builder().balance(123).number("1111").status(Status.BRONZE).build());
        discountCardDto = discountCardService.createDiscountCard("1111");
        assertEquals(123,discountCardDto.getBalance());
        assertEquals("1111",discountCardDto.getNumber());
        assertEquals(Status.BRONZE,discountCardDto.getStatus());
    }

    @Test
    void getDiscountCardById() {
        when(discountCardDao.getById(1L))
                .thenReturn(DiscountCard.builder().id(1L).balance(123).number("1111").status(Status.BRONZE).build());
        DiscountCardDto potentialDiscountCard = discountCardService.getDiscountCard(1L);
        assertEquals(discountCardDto,potentialDiscountCard);

    }

    @Test
    void getDiscountCardByNumber() {
        when(discountCardDao.getByNumber(any()))
                .thenReturn(DiscountCard.builder().balance(123).number("1111").status(Status.BRONZE).build());
        assertNotNull(discountCardService.getDiscountCardByNumber("1111"));
    }

    @Test
    void updateDiscountCard() {
        when(discountCardDao.update(any())).thenReturn(DiscountCard.builder().id(1L).balance(321).number("2222").status(Status.SILVER).build());
        discountCardDto = discountCardService.updateDiscountCard(DiscountCardDto.builder().id(1L).balance(321).number("2222").status(Status.SILVER).build());
        assertEquals(1L,discountCardDto.getId());
    }

    @Test
    void deleteDiscountCardByNumber() {
        when(discountCardDao.getByNumber("1111"))
                .thenReturn(DiscountCard.builder().balance(123).number("1111").status(Status.BRONZE).build());
        discountCardService.deleteDiscountCard("1111");
        verify(discountCardDao).deleteById(any());

    }

    @Test
    void changeStatus() {
        when(discountCardDao.getByNumber(any()))
                .thenReturn(DiscountCard.builder().balance(55).number("1111").status(Status.BRONZE).build());
        when(discountCardDao.update(any())).thenReturn(DiscountCard.builder().balance(55).number("1111").status(Status.SILVER).build());
        assertEquals(Status.SILVER,discountCardService.changeStatus(discountCardDto.getNumber()).getStatus());
        when(discountCardDao.update(any())).thenReturn(DiscountCard.builder().balance(20).number("1111").status(Status.BRONZE).build());
        assertEquals(Status.BRONZE,discountCardService.changeStatus(discountCardDto.getNumber()).getStatus());
        when(discountCardDao.update(any())).thenReturn(DiscountCard.builder().balance(100).number("1111").status(Status.GOLD).build());
        assertEquals(Status.GOLD,discountCardService.changeStatus(discountCardDto.getNumber()).getStatus());


    }

    @Test
    void addDetails() {
        when(detailsDao.save(any())).thenReturn(Details.builder().city("GRODNO")
                .firstName("Pavel").lastName("Kurilo").phoneNumber("+375297279574").build());
        when(discountCardDao.getByNumber(any()))
                .thenReturn(DiscountCard.builder().balance(123).number("1111").status(Status.BRONZE).build());
        when(discountCardDao.update(any())).thenReturn(DiscountCard.builder().balance(123).number("1111").status(Status.SILVER).details(Details.builder().city("GRODNO")
                .firstName("Pavel").lastName("Kurilo").phoneNumber("+375297279574").build()).build());

        DetailsDto details = DetailsDto.builder().city("GRODNO")
                .firstName("Pavel").lastName("Kurilo").phoneNumber("+375297279574").build();
        discountCardDto = discountCardService.addDetails(discountCardDto.getNumber(),details);

        assertEquals(details.getFirstName(),discountCardDto.getDetails().getFirstName());
        assertEquals(details.getLastName(),discountCardDto.getDetails().getLastName());
    }


}