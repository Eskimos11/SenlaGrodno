package com.senla.service;

import com.senla.api.dao.UserDao;
import com.senla.controller.dto.UserCreateDto;
import com.senla.controller.dto.UserDto;
import com.senla.dao.RoleDao;
import com.senla.entity.Role;
import com.senla.entity.User;
import com.senla.exception.UserNotFoundException;
import liquibase.pro.packaged.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService  {

    private final UserDao userDao;

    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto saveUser(UserCreateDto UserCreateDto) {
        final User user = mapper.map(UserCreateDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));


        final User savedUser = userDao.save(user);

        return mapper.map(savedUser,UserDto.class);
    }

    public void deleteUser(Integer id) {
       userDao.deleteById(id);
    }

    public UserCreateDto getUserInfo(Integer id) {
        final User user = ofNullable(userDao.getById(id))
                .orElseThrow(() ->  new UserNotFoundException(id));
        return mapper.map(user,UserCreateDto.class);
    }

    public UserDto updateUser(UserDto userDto) {
        final User user = mapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        final User updatedUser = userDao.update(user);
        return mapper.map(updatedUser,UserDto.class);
}


}


