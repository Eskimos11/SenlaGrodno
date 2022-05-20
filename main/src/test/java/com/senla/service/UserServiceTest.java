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
import com.senla.exception.UserFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.NoResultException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
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
    private UserCreateDto userCreateDtoDto;

    @BeforeEach
    public void init() {
        userCreateDtoDto = UserCreateDto.builder().username("user7").id(123L)
                .build();
    }

    @Test
    public void saveUserShouldFinishOk() {
        when(userDao.update(any())).thenReturn(User.builder().username("user7").id(123L)
                .role(Role.builder().name("USER").id(2L).build()).build());
        when(userDao.getByName(any())).thenThrow(NoResultException.class);
        UserCreateDto userCreateDtoDto = userService.createUser(
                UserCreateDto.builder().username("user7").id(123L).build());
        assertEquals(123L, userCreateDtoDto.getId());
        assertEquals("user7", userCreateDtoDto.getUsername());
    }

    @Test
    public void shouldThrowExceptionUserFound() {
        when(userDao.getByName(any())).thenReturn(User.builder().username("user7").id(123L)
                .role(Role.builder().name("USER").id(2L).build()).build());

        assertThrows(UserFoundException.class, () -> {
            userService.createUser(UserCreateDto.builder().username("user7").id(123L).build());
        });
    }

    @Test
    public void deleteUserTest() {
        userService.deleteUser(1L);
        verify(userDao).deleteById(1L);
    }

    @Test
    public void getUserInfoTest() {
        when(userDao.getById(1L)).thenReturn(User.builder().username("user7").id(1L)
                .role(Role.builder().name("USER").id(2L).build()).build());
        UserDto userDto = userService.getUserInfo(1L);
        assertEquals(1L, userDto.getId());
        assertEquals("user7", userDto.getUsername());

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

        assertEquals(user1.getUsername(), user2.getUsername());
    }

}

