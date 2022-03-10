package com.senla.controller.dto.UserDto;

import com.senla.controller.dto.DetailsDto;
import com.senla.entity.Details;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private DetailsDto details;
}
