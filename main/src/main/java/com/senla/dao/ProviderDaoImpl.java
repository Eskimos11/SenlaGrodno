package com.senla.dao;

import com.senla.api.dao.ProviderDao;
import com.senla.entity.Provider;

import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

@Repository
public class ProviderDaoImpl extends AbstractDao<Provider, Integer> implements ProviderDao {


    public ProviderDaoImpl() {
        super(Provider.class);
    }


    @Override
    public Provider update(Provider provider) {
        return entityManager.merge(provider);
    }

    @Override
    public void deleteById(Integer id) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaDelete<Provider> query = criteriaBuilder.createCriteriaDelete(Provider.class);
        query.from(Provider.class);
        entityManager.createQuery(query).executeUpdate();
    }

}





