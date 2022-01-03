package com.senla.dao;

import com.senla.api.dao.ProductDao;
import com.senla.api.dao.UserDao;
import com.senla.entity.Product;
import com.senla.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

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
}
