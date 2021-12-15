package com.senla.service;

import com.senla.api.dao.UserDao;
import com.senla.controller.dto.UserCreateDto;
import com.senla.controller.dto.UserDto;
import com.senla.entity.User;
import com.senla.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto saveUser(UserCreateDto userDto) {
        final User user = mapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        final User savedUser = userDao.save(user);

        return mapper.map(savedUser,UserDto.class);
    }

    public void deleteUser(Integer id) {
       userDao.deleteById(id);
    }

    public UserDto getUserInfo(Integer id) {
        final User user = ofNullable(userDao.getById(id))
                .orElseThrow(() ->  new UserNotFoundException(id));
        return mapper.map(user,UserDto.class);
    }

    public UserDto updateUser(UserDto userDto) {
        final User user = mapper.map(userDto, User.class);
        final User updatedUser = userDao.update(user);

}
