package com.senla.service;

import com.senla.api.dao.UserDao;
import com.senla.controller.dto.UserCreateDto;
import com.senla.controller.dto.UserDto;
import com.senla.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
//    @InjectMocks
//    private UserService userService;
//    @Spy
//    private ModelMapper mapper;
//    @Mock
//    private UserDao userDao;
//    @Spy
//    private PasswordEncoder passwordEncoder;
//
//    @Test
//    public void saveUser() {
//
//        final String username = "User";
//        final String password = "123";
//        when(userDao.save(any())).thenReturn(User.builder().username("User").password("123").id(123).build());
//
//        final UserDto userDto = userService.saveUser(
//                UserCreateDto.builder()
//                        .id(123)
//                        .username(username)
//                        .password(password)
//                        .build());
//
//        assertEquals(123, userDto.getId());
//        assertEquals(username, userDto.getUsername());
//        assertEquals(password, userDto.getPassword());
//    }
//    @Test
//    public void deleteUserTest(){
//        final String username = "User";
//        final String password = "123";
//        when(userDao.save(any())).thenReturn(User.builder().username("User").password("123").id(123).build());
//
//        final UserDto userDto = userService.saveUser(
//                UserCreateDto.builder()
//                        .id(123)
//                        .username(username)
//                        .password(password)
//                        .build());
//        userService.deleteUser(userDto.getId());
//        assertNull(userDao.getById(userDto.getId()));
//    }
//    @Test
//    public void getUserInfoTest() throws Exception{
//        final String username = "User";
//        final String password = "123";
//        when(userDao.save(any())).thenReturn(User.builder().username("User").password("123").id(123).build());
//
//         userService.saveUser(
//                UserCreateDto.builder()
//                        .id(123)
//                        .username(username)
//                        .password(password)
//                        .build());
//        UserCreateDto userCreateDto = userService.getUserInfo(123);
//        assertEquals(123,userCreateDto.getId());
//    }
//    @Test
//    public void updateUserTest(){
//        final String username = "User";
//        final String password = "123";
//        when(userDao.save(any())).thenReturn(User.builder().username("User").password("123").id(123).build());
//
//        final UserDto userDto = userService.saveUser(
//                UserCreateDto.builder()
//                        .id(123)
//                        .username(username)
//                        .password(password)
//                        .build());
//        UserDto updateUser = UserDto.builder().id(124).username("UpdateUser").password("1234").build();
//        userService.updateUser(updateUser);
//        assertEquals(1234,updateUser.getId());
//    }


}