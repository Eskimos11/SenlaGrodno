package com.senla.service;

import com.senla.api.dao.DetailsDao;
import com.senla.api.dao.UserDao;
import com.senla.controller.dto.DetailsDto;
import com.senla.controller.dto.UserDto.UserCreateDto;
import com.senla.controller.dto.UserDto.UserDto;
import com.senla.entity.Details;
import com.senla.entity.User;
import com.senla.exception.UserFoundException;
import com.senla.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import static java.util.Optional.ofNullable;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;
    private final DetailsDao detailsDao;

    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto saveUser(UserCreateDto UserCreateDto) {
        final User user = mapper.map(UserCreateDto, User.class);
        User savedUser = null;
        try {
            userDao.getByName(user.getUsername());

            throw new UserFoundException(user.getUsername());
        }catch (NoResultException e){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
           savedUser = userDao.save(user);

        }return mapper.map(savedUser, UserDto.class);
    }

    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }

    public UserCreateDto getUserInfo(Integer id) {
        final User user = ofNullable(userDao.getById(id))
                .orElseThrow(() -> new UserNotFoundException(id));
        return mapper.map(user, UserCreateDto.class);
    }

    public UserDto updateUser(UserDto userDto) {
        final User user = mapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        final User updatedUser = userDao.update(user);
        return mapper.map(updatedUser, UserDto.class);
    }
    public UserDto addDetails(Integer userId, DetailsDto detailsDto){
        final Details details = mapper.map(detailsDto, Details.class);
        detailsDao.save(details);
        User user  = userDao.getById(userId);
        user.setDetails(details);
        final User updateUser = userDao.update(user);
        return mapper.map(updateUser,UserDto.class);
    }

}

