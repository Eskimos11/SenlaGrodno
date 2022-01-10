package com.senla.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailsDto {

    private String name;
    private String lastName;
    private String city;
    private String phoneNumber;
}
