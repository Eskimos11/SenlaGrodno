package com.senla.controller.dto;



import com.senla.entity.Details;
import com.senla.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    private Integer id;
    private String username;
    private String password;
    private Details details;
}

