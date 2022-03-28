package com.senla.dao;
import com.senla.api.dao.ProductDao;
import com.senla.entity.*;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl extends AbstractDao<Product, Long> implements ProductDao {

    public ProductDaoImpl() {
        super(Product.class);
    }

    @Override
    public Product update(Product product) {
        return entityManager.merge(product);
    }

    @Override
    public void deleteById(Long id) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaDelete<Product> query = criteriaBuilder.createCriteriaDelete(Product.class);
        final Root<Product> rows = query.from(Product.class);
        query.where(criteriaBuilder.equal(rows.get(Product_.id), id));
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

    @Override
    public List<Product> getProductLimit(Integer amount) {
        return  entityManager.createQuery("Select t from Product t where t.amount <=:amount")
            .setParameter("amount", amount).getResultList();
    }



}
