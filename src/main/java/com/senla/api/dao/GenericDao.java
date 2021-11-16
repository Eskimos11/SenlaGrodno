package com.senla.api.dao;

import com.senla.entity.AEntity;
import com.senla.entity.Provider;

public interface GenericDao<T extends AEntity> {

    void save(T entity);

    T getById(Integer id);

    T update(T entity);

    void delete (T entity);

}
