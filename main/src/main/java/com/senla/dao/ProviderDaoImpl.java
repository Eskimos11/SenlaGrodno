package com.senla.dao;

import com.Value;
import com.senla.entity.Provider;

import java.util.List;

public class ProviderDaoImpl extends AbstractDao<Provider> implements com.senla.api.dao.ProviderDao {

    @Value("dao")
    private String someText;
    @Override
    public String doo(){
        System.out.println(someText);
        return  someText;
    }

    @Override
    public void saveAll(List<Provider> entity) {

    }

    @Override
    public Provider getById(Integer id) {
        return null;
    }

    @Override
    public List<Provider> getAll() {
        return null;
    }

    @Override
    public void delete(Provider entity) {

    }

    @Override
    public Provider update(Provider entity) {
        return null;
    }
}
