package com.senla.dao;



import com.senla.api.dao.GenericDao;
import com.senla.entity.AEntity;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractDao<T extends AEntity> implements GenericDao<T> {

    //todo Все сделано в Provider

    private List<T> repository = new ArrayList<>();


    @Override
    public void save(T entity) {
        repository.add(entity);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(repository);
    }

//    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
//    protected EntityManager entityManager;
//
//
//    @Override
//    public void save(T entity) {
//        entityManager.persist(entity);
//
//    }
//
//    @Override
//    public T getById(Integer id) {
//        return entityManager.find(getClazz(), id);
//    }
//
//    @Override
//    public void delete(T entity) {
//        entityManager.remove(entity);
//    }
//
//    @Override
//    public List<T> getAll() {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<T> cq = cb.createQuery(getClazz());
//        Root<T> rootEntry = cq.from(getClazz());
//        CriteriaQuery<T> all = cq.select(rootEntry);
//
//        TypedQuery<T> allQuery = entityManager.createQuery(all);
//        return allQuery.getResultList();
//    }
//
//    public T update(T entity) {
//        return entityManager.merge(entity);
//    }
//
//    protected abstract Class<T> getClazz();


}
