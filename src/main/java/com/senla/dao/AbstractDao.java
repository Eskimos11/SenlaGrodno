package com.senla.dao;

import com.senla.api.dao.GenericDao;
import com.senla.entity.AEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public abstract class AbstractDao<T extends AEntity> implements GenericDao<T> {

}




