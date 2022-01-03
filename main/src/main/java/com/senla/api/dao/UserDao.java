package com.senla.api.dao;


import com.senla.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface UserDao extends GenericDao<User, Integer> {
    User update(User user);

    void deleteById(Integer id);

    User getByName(String name);

    List<User> getAll();

    User getByNameWithRole(String name);

}
