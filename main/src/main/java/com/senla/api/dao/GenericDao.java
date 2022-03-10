package com.senla.api.dao;


public interface GenericDao<Entity, Id> {

    Entity save(Entity entity);

    Entity getById(Id id);

    Entity update(Entity entity);

    void deleteById(Id id);

}
