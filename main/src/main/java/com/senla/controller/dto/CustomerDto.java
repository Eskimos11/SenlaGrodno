package com.senla.controller.dto;

import com.senla.entity.DiscountCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Integer id;
    private String name;
    private DiscountCard discountCard;

}
