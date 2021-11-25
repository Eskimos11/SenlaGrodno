package com.senla.dao;

import com.senla.api.dao.ProviderDao;
import com.senla.entity.Provider;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ProviderDaoImpl extends AbstractDao<Provider> implements ProviderDao {

    @Override
    protected Class<Provider> getClazz(){
        return Provider.class;
    }
}




