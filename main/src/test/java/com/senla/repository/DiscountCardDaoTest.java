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
    private DiscountCard discountCardToRemove;
    private DiscountCard discountCardToUpdate;


    @BeforeAll
    public void createCard() {
        discountCard = discountCardDao.save(DiscountCard.builder().
                balance(12).number("1111").
                status(Status.BRONZE).build());
        discountCardToRemove = discountCardDao.save(DiscountCard.builder().
                balance(12).number("222").
                status(Status.GOLD).build());
        discountCardToUpdate = discountCardDao.save(DiscountCard.builder().
                balance(13).number("123").
                status(Status.SILVER).build());
    }

    @Test
    public void getCartById() {
        assertNotNull(discountCard.getId());
    }

    @Test
    public void getCardByNumber() {
        discountCardDao.save(DiscountCard.builder().
                balance(12).number("4321").
                status(Status.BRONZE).build());
        DiscountCard potentialDiscountCard = discountCardDao.getByNumber("4321");
        assertEquals("4321", potentialDiscountCard.getNumber());
    }

    @Test
    public void deleteCartById() {
        discountCardDao.deleteById(discountCardToRemove.getId());
        DiscountCard discountCard1 = discountCardDao.getById(discountCardToRemove.getId());
        assertNull(discountCard1);
    }

    @Test
    public void updateDiscountCard() {
        discountCard = discountCardDao.update(discountCardToUpdate);
        assertEquals(discountCardToUpdate.getNumber(), discountCard.getNumber());
    }
}

