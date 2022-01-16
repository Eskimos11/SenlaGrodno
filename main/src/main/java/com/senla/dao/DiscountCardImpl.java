package com.senla.dao;

import com.senla.api.dao.DiscountCardDao;
import com.senla.api.dao.OrdersDao;
import com.senla.entity.*;
import liquibase.pro.packaged.D;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class DiscountCardImpl extends AbstractDao<DiscountCard, Integer> implements DiscountCardDao {

    public DiscountCardImpl() {
        super(DiscountCard.class);
    }

    @Override
    public DiscountCard update(DiscountCard discountCard) {
        return entityManager.merge(discountCard);
    }
    @Override
    public DiscountCard getByNumber(String number) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<DiscountCard> query = criteriaBuilder.createQuery(DiscountCard.class);
        final Root<DiscountCard> rows = query.from(DiscountCard.class);
        query.where(criteriaBuilder.equal(rows.get(DiscountCard_.number), number));
        return entityManager.createQuery(query).getSingleResult();
    }
    @Override
    public List<DiscountCard> getAll() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<DiscountCard> query = criteriaBuilder.createQuery(DiscountCard.class);
        query.from(DiscountCard.class);
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public void deleteById(Integer id) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaDelete<DiscountCard> query = criteriaBuilder.createCriteriaDelete(DiscountCard.class);
        query.from(DiscountCard.class);
        entityManager.createQuery(query).executeUpdate();
    }

}
