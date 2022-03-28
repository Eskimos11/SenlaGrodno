package com.senla.dao;

import com.senla.api.dao.OrdersDao;
import com.senla.entity.*;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrdersDaoImpl extends AbstractDao<Orders, Long> implements OrdersDao {

    public OrdersDaoImpl() {
        super(Orders.class);
    }

    @Override
    public Orders update(Orders order) {
        return entityManager.merge(order);
    }

    @Override
    public void deleteById(Long id) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaDelete<Orders> query = criteriaBuilder.createCriteriaDelete(Orders.class);
        final Root<Orders> rows = query.from(Orders.class);
        query.where(criteriaBuilder.equal(rows.get(Orders_.id), id));
        entityManager.createQuery(query).executeUpdate();
    }
    @Override
    public List<Product> getProductFromOrder(Long id) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery q = cb.createQuery(Product.class);
        Root o = q.from(Orders.class);
        o.fetch("productList", JoinType.INNER);
        q.select(o);
        q.where(cb.equal(o.get("id"), id));

        List<Orders> ordersList = entityManager.createQuery(q).getResultList();
        List<Product> productList = new ArrayList<>();
        if (ordersList.isEmpty()) {
            return productList;
        } else return ordersList.get(0).getProductList();
    }
}


