package com.senla.api.dao;


import com.senla.entity.AEntity;

import java.util.List;

public interface GenericDao<T extends AEntity> {



    void save(T entity);

    void saveAll(List<T> entity);

    T getById(Integer id);

    List<T> getAll();

    void delete(T entity);

    T update(T entity);

}
