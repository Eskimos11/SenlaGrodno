package com.senla.api.dao;

import javax.transaction.Transactional;

@Transactional
public interface GenericDao<Entity, Id> {

    Entity save(Entity entity);

    Entity getById(Id id);

    Entity update(Entity entity);

    void deleteById(Id id);

}
