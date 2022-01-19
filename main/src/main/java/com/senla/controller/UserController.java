package com.senla.controller;

import com.senla.controller.dto.DetailsDto;
import com.senla.controller.dto.UserDto.UserCreateDto;
import com.senla.controller.dto.UserDto.UserDto;
import com.senla.entity.User;
import com.senla.security.UserDetailServiceImpl;
import com.senla.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/{id}")
    public UserDto getById(@PathVariable Integer id, @AuthenticationPrincipal UserDetails userDetails) {
        return userService.getUserInfo(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @PutMapping("/{userId}")
    public UserDto addDetails(@PathVariable Integer userId,
                              @RequestBody DetailsDto detailsDto) {
        return userService.addDetails(userId, detailsDto);
    }

}


