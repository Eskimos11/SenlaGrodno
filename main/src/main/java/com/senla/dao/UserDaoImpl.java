package com.senla.dao;

import com.senla.api.dao.UserDao;
import com.senla.entity.User;
import com.senla.entity.User_;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;

@Repository
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }
    @Override
    public User getByName(String name) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        final Root<User> rows = query.from(User.class);
        query.where(criteriaBuilder.equal(rows.get(User_.username), name));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public User getByNameWithRole(String name) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        final Root<User> rows = query.from(User.class);
        query.where(criteriaBuilder.equal(rows.get(User_.username), name));
        rows.fetch(User_.role, JoinType.LEFT);
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaDelete<User> query = criteriaBuilder.createCriteriaDelete(User.class);
        final Root<User> rows = query.from(User.class);
        query.where(criteriaBuilder.equal(rows.get(User_.id), id));
        entityManager.createQuery(query).executeUpdate();
    }

}
