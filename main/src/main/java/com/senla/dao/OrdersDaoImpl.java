package com.senla.dao;

import com.senla.api.dao.OrdersDao;
import com.senla.entity.*;
import liquibase.pro.packaged.O;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

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
    public List<Orders> getAll() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Orders> query = criteriaBuilder.createQuery(Orders.class);
        query.from(Orders.class);
        return entityManager.createQuery(query).getResultList();
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


