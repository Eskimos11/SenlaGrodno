package com.senla.controller;

import com.senla.controller.dto.ProviderCreateDto;
import com.senla.controller.dto.ProviderDto;
import com.senla.controller.dto.UserCreateDto;
import com.senla.controller.dto.UserDto;
import com.senla.service.ProviderService;
import com.senla.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @PostMapping
    public UserDto createUser(@RequestBody UserCreateDto userDto) {
        return userService.saveUser(userDto);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
    @GetMapping(value = "/{id}")
    @Secured("ROLE_ADMIN")
    public UserCreateDto getById(@PathVariable Integer id) {
        return userService.getUserInfo(id);
    }
    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);

    }

}


