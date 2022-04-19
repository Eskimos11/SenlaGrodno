package com.senla.security;

import com.senla.api.dao.UserDao;
import com.senla.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = Optional.of(userDao.getByNameWithRole(username))
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found "));

        return new User(
                user.getUsername(),
                user.getPassword(),
                Optional.ofNullable(user.getRole()).map(Role::getName).map(
                        x -> List.of(
                                new SimpleGrantedAuthority(
                                        "ROLE_" + x
                                )
                        )
                ).orElse(Collections.emptyList())
        );
    }



}

