package com.senla.dao;

import com.senla.api.dao.OrdersDao;
import com.senla.entity.*;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.*;

@Repository
public class OrdersDaoImpl extends AbstractDao<Orders, Integer> implements OrdersDao {

    public OrdersDaoImpl() {
        super(Orders.class);
    }

    @Override
    public Orders update(Orders order) {
        return entityManager.merge(order);
    }

    @Override
    public void deleteById(Integer id) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaDelete<Orders> query = criteriaBuilder.createCriteriaDelete(Orders.class);
        final Root<Orders> rows = query.from(Orders.class);
        query.where(criteriaBuilder.equal(rows.get(Orders_.id), id));
        entityManager.createQuery(query).executeUpdate();
    }
}


