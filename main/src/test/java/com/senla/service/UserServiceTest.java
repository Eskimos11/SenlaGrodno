package com.senla.service;

import com.senla.api.dao.UserDao;
import com.senla.controller.dto.UserDto.UserCreateDto;
import com.senla.controller.dto.UserDto.UserDto;
import com.senla.entity.User;
import com.senla.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.NoResultException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Spy
    private ModelMapper mapper;
    @Mock
    private UserDao userDao;

    @Test
    public void saveUserShouldFinishOk() {

//        final String userName = "user";
//        when(userDao.save(any())).thenReturn(User.builder().username(userName).id(123).build());
//
//        final UserDto userDto = userService.saveUser(
//                UserCreateDto.builder()
//                        .username(userName)
//                        .build());
//
//        assertEquals(123, userDto.getId());
//        assertEquals(userName, userDto.getUsername());
    }

    @Test()
    public void deleteUserTest() {
//        final String userName = "user";
//        when(userDao.save(any())).thenReturn(User.builder().username(userName).id(123).build());
//        final User mike =
//                userDao.save(
//                        User.builder()
//                                .username("user")
//                                .build()
//                );
//        userService.deleteUser(mike.getId());
//        assertNull(userDao.getById(mike.getId()));
    }

//    @Test
//    public void getUserInfoTest() {
//        final String userName = "user";
//        final String password = "user";
//        when(userDao.save(any())).thenReturn(User.builder().password(password).username(userName).id(123).build());
//         userDao.save(User.builder()
//                .id(123)
//                .username(userName)
//                .password(password)
//                .build()
//        );
//        UserCreateDto user = userService.getUserInfo(123);
//        assertEquals(1, user.getId());
//        assertEquals("user", user.getUsername());
//        assertEquals(123, user.getPassword());
//    }
}
