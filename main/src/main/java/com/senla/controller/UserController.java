package com.senla.controller;

import com.senla.controller.dto.DetailsDto;
import com.senla.controller.dto.UserDto.UserCreateDto;
import com.senla.controller.dto.UserDto.UserDto;
import com.senla.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
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
    public UserCreateDto getById(@PathVariable Integer id) {
        return userService.getUserInfo(id);
    }
    @PutMapping
    @Secured("ROLE_ADMIN")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }
    @PutMapping("/{userId}/")
    public UserDto addDetails(@PathVariable Integer userId,
                              @RequestBody DetailsDto detailsDto){
        return userService.addDetails(userId,detailsDto);
    }

}


