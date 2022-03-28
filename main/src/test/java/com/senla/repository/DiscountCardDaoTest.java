package com.senla.repository;

import com.senla.BaseRepositoryTest;
import com.senla.api.dao.DiscountCardDao;
import com.senla.dao.DiscountCardDaoImpl;
import com.senla.entity.DiscountCard;
import com.senla.entity.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = DiscountCardDaoImpl.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DiscountCardDaoTest extends BaseRepositoryTest {
    @Autowired
    private DiscountCardDao discountCardDao;
    private DiscountCard discountCard;


    @BeforeAll
    public void createCard() {
        discountCard = discountCardDao.save(DiscountCard.builder().
                balance(12).number("1111").
                status(Status.BRONZE).build());
    }

    @Test
    public void getCartById() {
        assertNotNull(discountCard.getId());
    }

    @Test
    public void getCardByNumber() {
//        DiscountCard potentialDiscountCard = discountCardDao.getByNumber(discountCard1.getNumber());
//        assertEquals(discountCard1, potentialDiscountCard);
    }

    @Test
    public void deleteCartById() {
        discountCardDao.deleteById(discountCard.getId());
        DiscountCard discountCard1 = discountCardDao.getById(discountCard.getId());
        assertNull(discountCard1);
    }

    @Test
    public void updateDiscountCard() {
        DiscountCard discountCard1 = discountCardDao.save(DiscountCard.builder().
                balance(123).number("2222").
                status(Status.GOLD).build());
        discountCard = discountCardDao.update(discountCard1);
        assertEquals(discountCard1.getId(),discountCard.getId());
    }
}

