package com.senla.dao;

import com.senla.api.dao.DiscountCardDao;
import com.senla.entity.*;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.*;

@Repository
public class DiscountCardDaoImpl extends AbstractDao<DiscountCard, Long> implements DiscountCardDao {

    public DiscountCardDaoImpl() {
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
    public void deleteById(Long id) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaDelete<DiscountCard> query = criteriaBuilder.createCriteriaDelete(DiscountCard.class);
        final Root<DiscountCard> rows = query.from(DiscountCard.class);
        query.where(criteriaBuilder.equal(rows.get(DiscountCard_.id), id));
        entityManager.createQuery(query).executeUpdate();
    }

}
