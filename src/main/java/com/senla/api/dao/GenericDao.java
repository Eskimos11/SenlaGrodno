package com.senla.api.dao;

import com.senla.entity.AEntity;

import javax.transaction.Transactional;

@Transactional
public interface GenericDao<T extends AEntity> {

    T save(T entity);

    T getById(Integer id);

    T update(T entity);

    void delete(Integer id);

}
