package com.senla.service;

import com.senla.api.dao.DetailsDao;
import com.senla.api.dao.UserDao;
import com.senla.controller.dto.DetailsDto;
import com.senla.controller.dto.UserDto.UserCreateDto;
import com.senla.controller.dto.UserDto.UserDto;
import com.senla.dao.RoleDao;
import com.senla.entity.Details;
import com.senla.entity.User;
import com.senla.exception.NoAccessRightsException;
import com.senla.exception.UserFoundException;
import com.senla.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
@Log4j
public class UserService {

    private final UserDao userDao;
    private final DetailsDao detailsDao;
    private final RoleDao roleDao;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserCreateDto createUser(UserCreateDto userDto) {
        final User user = mapper.map(userDto, User.class);
        User savedUser = null;
        try {
            userDao.getByName(user.getUsername());
            throw new UserFoundException(user.getUsername());
        } catch (NoResultException e) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(roleDao.getById(2));
            savedUser = userDao.update(user);
        }
        return mapper.map(savedUser, UserCreateDto.class);
    }
    @Transactional
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }
    @Transactional
    public UserDto getUserInfo(Integer id) {

        final User user = ofNullable(userDao.getById(id))
                .orElseThrow(() -> new UserNotFoundException(id));

        return mapper.map(user, UserDto.class);
    }
    @Transactional
    public UserDto updateUser(UserDto userDto) {
        final User user = mapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        final User updatedUser = userDao.update(user);
        return mapper.map(updatedUser, UserDto.class);
    }

    @Transactional
    public UserDto addDetails(Integer userId, DetailsDto detailsDto,Integer id) {
        final Details details = mapper.map(detailsDto, Details.class);
        if(!userId.equals(id))
            throw new NoAccessRightsException("");
        detailsDao.save(details);
        User user = ofNullable(userDao.getById(id))
                .orElseThrow(() -> new UserNotFoundException(userId));;
        user.setDetails(details);
        final User updateUser = userDao.update(user);
        return mapper.map(updateUser, UserDto.class);
    }
}

