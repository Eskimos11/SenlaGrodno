package com.senla.api.dao;


import com.senla.entity.AEntity;

import java.util.List;

public interface GenericDao<T extends AEntity> {

    void save(T entity);

}
