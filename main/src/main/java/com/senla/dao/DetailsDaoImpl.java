package com.senla.dao;

import com.senla.api.dao.DetailsDao;
import com.senla.entity.*;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

@Repository
public class DetailsDaoImpl extends AbstractDao<Details, Long> implements DetailsDao {

    public DetailsDaoImpl() {
        super(Details.class);
    }

    @Override
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    public void deleteById(Long id) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaDelete<Details> query = criteriaBuilder.createCriteriaDelete(Details.class);
        final Root<Details> rows = query.from(Details.class);
        query.where(criteriaBuilder.equal(rows.get(Details_.id), id));
        entityManager.createQuery(query).executeUpdate();
    }
}
