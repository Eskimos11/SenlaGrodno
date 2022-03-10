package com.senla.controller;

import com.senla.controller.dto.DetailsDto;
import com.senla.controller.dto.UserDto.UserCreateDto;
import com.senla.controller.dto.UserDto.UserDto;
import com.senla.entity.User;
import com.senla.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserCreateDto createUser(@RequestBody UserCreateDto userDto) {
        return userService.createUser(userDto);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(value = "/{id}")
    public UserDto getById(@PathVariable Integer id) {
        return userService.getUserInfo(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PutMapping("/{userId}")
    public UserDto addDetails(@PathVariable Integer userId,
                              @RequestBody DetailsDto detailsDto,
                              @AuthenticationPrincipal Integer id) {
        return userService.addDetails(userId, detailsDto,id);
    }
}


