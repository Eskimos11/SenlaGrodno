package com.senla.dao;

import com.senla.api.dao.OrdersDao;
import com.senla.entity.Orders;
import com.senla.entity.User;
import org.springframework.stereotype.Repository;

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
//        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        final CriteriaQuery<User> query = criteriaBuilder.createQuery(Order.class);
//        query.from(Order.class);
//        return entityManager.createQuery(query).getResultList();
        return null;
    }


    @Override
    public void deleteById(Integer id) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaDelete<Orders> query = criteriaBuilder.createCriteriaDelete(Orders.class);
        query.from(Orders.class);
        entityManager.createQuery(query).executeUpdate();
    }
}
