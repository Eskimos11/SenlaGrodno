package com.senla.dao;

import com.senla.api.dao.ProductDao;
import com.senla.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class ProductDaoImpl extends AbstractDao<Product, Integer> implements ProductDao {

    public ProductDaoImpl() {
        super(Product.class);
    }

    @Override
    public Product update(Product product) {
        return entityManager.merge(product);
    }

    @Override
    public void deleteById(Integer integer) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaDelete<Product> query = criteriaBuilder.createCriteriaDelete(Product.class);
        query.from(Product.class);
        entityManager.createQuery(query).executeUpdate();
    }
    @Override
    public Product getByTitle(String title) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        final Root<Product> from = query.from(Product.class);

        return entityManager.createQuery(
                query.select(from)
                        .where(criteriaBuilder.equal(from.get(Product_.title), title))
        ).getSingleResult();
    }

}
