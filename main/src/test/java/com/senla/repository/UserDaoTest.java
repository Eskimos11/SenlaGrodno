package com.senla.repository;

import com.senla.BaseRepositoryTest;
import com.senla.api.dao.UserDao;
import com.senla.dao.UserDaoImpl;
import com.senla.entity.Role;
import com.senla.entity.User;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.NoResultException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ContextConfiguration(classes = UserDaoImpl.class)
public class UserDaoTest extends BaseRepositoryTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void jpaShouldSetIdWhenEntitySaved() {
        final User mike =
                userDao.save(
                        User.builder()
                                .username("user")
                                .build()
                );

        assertNotNull(mike.getId());
    }

    @Test
    public void repositoryShouldThrowExceptionWhenUserNotFoundByName() {
        assertThrows(NoResultException.class, () -> {
            userDao.getByName("absent-name");
        });
    }

    @Test
    public void shouldFindEntityByNameCorrect() {
        final String userName = "user";
        final User mike = userDao.save(
                User.builder()
                        .username(userName)
                        .build()
        );
        final User potentialMike = userDao.getByName(userName);

        assertEquals(mike.getId(), potentialMike.getId());
    }

    @Test
    public void shouldFinishWithLazyException() {

        final String userName = "user";
        userDao.save(
                User.builder()
                        .username(userName)
                        .role(Role.builder().name("user").build())
                        .build()
        );
        assertThrows(
                LazyInitializationException.class,
                () -> userDao.getByName(userName).getRole().getName()
        );
    }

    @Test
    public void shouldReturnAllUsers() {
        final String userName = "user";
        userDao.save(
                User.builder()
                        .username(userName)
                        .build()
        );

        final List<User> all = userDao.getAll();

        assertEquals(1, all.size());
        final User user = all.get(0);
        assertEquals("user", user.getUsername());
        assertNotNull(user.getId());
    }
}
