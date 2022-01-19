package com.senla.dao;

import com.senla.entity.Role;
import com.senla.entity.Role_;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;

@Repository
public class RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Role role) {
        entityManager.persist(role);
    }

    public Role getById(Integer roleId) {
        return entityManager.find(Role.class, roleId);
    }


    public Role getByName(String name) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Role> query = criteriaBuilder.createQuery(Role.class);
        final Root<Role> from = query.from(Role.class);

        return entityManager.createQuery(
                query.select(from)
                        .where(criteriaBuilder.equal(from.get(Role_.name), name))
        ).getSingleResult();
    }

    public Role getReferenceById(Long roleId) {
        return entityManager.getReference(Role.class, roleId);
    }
}
