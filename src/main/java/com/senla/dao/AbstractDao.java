package com.senla.dao;

import com.senla.api.dao.GenericDao;
import com.senla.entity.AEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

@Repository
public abstract class AbstractDao<T extends AEntity> implements GenericDao<T> {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;

    @Override
    @Transactional
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T getById(Integer id) {
        return entityManager.find(getClazz(), id);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(id);
    }


    public T update(T entity) {
        return entityManager.merge(entity);
    }

    protected abstract Class<T> getClazz();


}

