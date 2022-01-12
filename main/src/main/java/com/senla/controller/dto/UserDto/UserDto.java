package com.senla.controller.dto.UserDto;

import com.senla.entity.Details;
import com.senla.entity.Role;
import liquibase.pro.packaged.R;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private Details details;
}
