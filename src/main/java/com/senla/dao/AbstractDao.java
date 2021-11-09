package com.senla.dao;

import com.senla.api.dao.GenericDao;
import com.senla.entity.AEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public abstract class AbstractDao<T extends AEntity> implements GenericDao<T> {

    private List<T> repository = new ArrayList<>();

    @Override
    public void save(T entity) {
        if (isObjectAlreadyExists(entity)) {
            repository.add(entity);
        }
    }

    @Override
    public T getById(Integer id) {
        T model = null;
        for (T entity : repository) {
            if (id.equals(entity.getId())) {
                model = entity;
            }
        }
        return model;
    }

    @Override
    public void delete(T entity) {
        repository.remove(entity);
    }

    @Override
    public T update(Integer id, T entity) {
        T model = getById(id);
        if (isObjectAlreadyExists(model)) {
            repository.remove(model);
            model = entity;
            repository.add(model);
        } else
            System.out.println("object does not exist");
        return model;
    }

    protected boolean isObjectAlreadyExists(T e) {
        if(e == null){
            return false;
        }else
        return true;
    }
}



