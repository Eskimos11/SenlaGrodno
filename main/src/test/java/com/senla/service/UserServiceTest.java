package com.senla.service;

import com.senla.api.dao.DetailsDao;
import com.senla.api.dao.UserDao;
import com.senla.controller.dto.DetailsDto;
import com.senla.controller.dto.UserDto.UserCreateDto;
import com.senla.controller.dto.UserDto.UserDto;
import com.senla.dao.RoleDao;
import com.senla.entity.Details;
import com.senla.entity.Role;
import com.senla.entity.User;
import org.junit.jupiter.api.BeforeEach;
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

    @InjectMocks
    private UserService userService;
    @Spy
    private ModelMapper mapper;
    @Mock
    private UserDao userDao;
    @Mock
    private RoleDao roleDao;
    @Mock
    private DetailsDao detailsDao;
    @Spy
    private PasswordEncoder passwordEncoder;
    private UserCreateDto userDto;

    @BeforeEach
    public void init() {
        final String userName = "user7";
        when(roleDao.getById(2L)).thenReturn(Role.builder().name("USER").id(2L).build());
        when(userDao.update(any())).thenReturn(User.builder().username("user7").id(123L)
                .role(Role.builder().name("USER").id(2L).build()).build());

        userDto = userService.createUser(
                UserCreateDto.builder()
                        .username(userName)
                        .build());
    }

    @Test
    public void saveUserShouldFinishOk() {
        final String userName = "user7";
        when(roleDao.getById(2L)).thenReturn(Role.builder().name("USER").id(2L).build());
        when(userDao.update(any())).thenReturn(User.builder().username("user7").id(123L)
                .role(Role.builder().name("USER").id(2L).build()).build());

        UserCreateDto userDto = userService.createUser(
                UserCreateDto.builder()
                        .username(userName)
                        .build());
        assertEquals(123L, userDto.getId());
        assertEquals("user7", userDto.getUsername());
    }

    @Test()
    public void deleteUserTest() {
        userService.deleteUser(userDto.getId());
        assertNull(userDao.getById(userDto.getId()));
    }

    @Test
    public void getUserInfoTest() {
        when(userDao.getById(any())).thenReturn(User.builder().username("user7").id(123L)
                .role(Role.builder().name("USER").id(2L).build()).build());
        UserDto user = userService.getUserInfo(123L);
        assertEquals(123L, user.getId());
        assertEquals("user7", user.getUsername());
    }

    @Test
    public void addDetailTest() {
        when(detailsDao.save(any())).thenReturn(Details.builder()
                .firstName("Pavel").build());
        when(userDao.getById(any())).thenReturn(User.builder().username("user7").id(123L).build());
        when(userDao.update(any())).thenReturn(User.builder().username("user7").id(123L).details(Details.builder()
                .firstName("Pavel").build()).build());
        DetailsDto detailsDto = DetailsDto.builder()
                .firstName("Pavel").build();
        UserDto userDto = UserDto.builder().username("user7").id(123L).build();
        userDto = userService.addDetails(userDto.getId(), detailsDto);
        assertEquals(detailsDto, userDto.getDetails());
    }

    @Test
    public void updateUserTest() {
        when(userDao.update(any())).thenReturn(User.builder().username("Mike").id(123L).details(Details.builder()
                .firstName("Pavel").build()).build());
        UserDto user1 = UserDto.builder().id(1L).username("Nike").id(123L).build();
        UserDto user2 = UserDto.builder().id(1L).username("Mike").id(123L).build();
        user1 = userService.updateUser(user2);

        assertEquals(user1.getUsername(),user2.getUsername());
    }
//    @Transactional
//    public UserDto updateUser(UserDto userDto) {
//        final User user = mapper.map(userDto, User.class);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        final User updatedUser = userDao.update(user);
//        return mapper.map(updatedUser, UserDto.class);
//    }


}

