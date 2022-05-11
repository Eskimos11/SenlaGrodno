package com.senla.dao;

import com.senla.api.dao.ProductAmountDao;
import com.senla.entity.Details;
import com.senla.entity.Details_;
import com.senla.entity.ProductAmount;
import org.springframework.stereotype.Repository;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;


@Repository
public class ProductAmountDaoImpl extends AbstractDao<ProductAmount, Long> implements ProductAmountDao {

    public ProductAmountDaoImpl() {
        super(ProductAmount.class);
    }

    @Override
    public ProductAmount update(ProductAmount details) {
        return entityManager.merge(details);
    }

    @Override
    public void deleteById(Long id) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaDelete<Details> query = criteriaBuilder.createCriteriaDelete(Details.class);
        final Root<Details> rows = query.from(Details.class);
        query.where(criteriaBuilder.equal(rows.get(Details_.id), id));
        entityManager.createQuery(query).executeUpdate();
    }
}

