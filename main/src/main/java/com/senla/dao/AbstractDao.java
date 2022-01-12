package com.senla.dao;

import com.senla.api.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<Entity, Id> implements GenericDao<Entity, Id> {

    @PersistenceContext
    protected EntityManager entityManager;
    protected Class<Entity> entityClass;

    public AbstractDao(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Entity save(Entity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Entity getById(Id id) {
        return entityManager.find(entityClass, id);
    }
}


