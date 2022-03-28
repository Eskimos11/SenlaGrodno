package com.senla.api.dao;

import com.senla.entity.User;

public interface UserDao extends GenericDao<User, Long> {

    User update(User user);

    void deleteById(Long id);

    User getByName(String name);

    User getByNameWithRole(String name);

}
