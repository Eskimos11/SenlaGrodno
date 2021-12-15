package com.senla.controller;

import com.senla.controller.dto.ProviderCreateDto;
import com.senla.controller.dto.ProviderDto;
import com.senla.controller.dto.UserCreateDto;
import com.senla.controller.dto.UserDto;
import com.senla.service.ProviderService;
import com.senla.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @PostMapping
    public UserDto createUser(@RequestBody UserCreateDto userDto) {
        return userService.saveUser(userDto);
    }
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Integer id) {
//        userService.(id);
//    }
    @GetMapping(value = "/{id}")
    public UserDto getById(@PathVariable Integer id) {
        return userService.getUserInfo(id);
    }
}


