package com.senla.api.dao;

import com.senla.entity.User;

public interface UserDao extends GenericDao<User, Integer> {

    User update(User user);

    void deleteById(Integer id);

    User getByName(String name);

    User getByNameWithRole(String name);

}
