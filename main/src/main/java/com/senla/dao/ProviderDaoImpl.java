package com.senla.dao;

import com.senla.api.dao.ProviderDao;
import com.senla.entity.Provider;

import com.senla.entity.Provider_;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

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
        final Root<Provider> rows = query.from(Provider.class);
        query.where(criteriaBuilder.equal(rows.get(Provider_.id), id));
        entityManager.createQuery(query).executeUpdate();
    }

}





