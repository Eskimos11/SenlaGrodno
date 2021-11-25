package com.senla.dao;

import com.senla.api.dao.CustomerDao;
import com.senla.entity.Customer;
import org.springframework.stereotype.Component;

@Component("customerDao")
public class CustomerDaoImpl extends AbstractDao<Customer> implements CustomerDao {
    @Override
    public Customer getByIdWith(Integer id) {
        return entityManager.createQuery("select customer from Customer customer left join fetch customer.discountCard where customer.id = :id", Customer.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    protected Class<Customer> getClazz() {
        return Customer.class;
    }

}
