package com.senla.api.dao;

import com.senla.entity.AEntity;

public interface GenericDao<T extends AEntity> {

    void save(T entity);

    T getById(Integer id);

    T update(Integer id, T entity);

    void delete (T entity);

}
