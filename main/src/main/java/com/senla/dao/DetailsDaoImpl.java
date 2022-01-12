package com.senla.dao;

import com.senla.api.dao.DetailsDao;
import com.senla.api.dao.OrdersDao;
import com.senla.entity.Details;
import com.senla.entity.Orders;
import com.senla.entity.Product;
import com.senla.entity.User;
import liquibase.pro.packaged.D;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetailsDaoImpl extends AbstractDao<Details, Integer> implements DetailsDao {

    public DetailsDaoImpl() {
        super(Details.class);
    }

    @Override
    public Details update(Details details) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
