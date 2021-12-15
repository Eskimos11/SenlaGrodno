package com.senla.controller.dto;

import com.senla.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {

    private String username;
    private String password;
    private List<Role> role;
}
