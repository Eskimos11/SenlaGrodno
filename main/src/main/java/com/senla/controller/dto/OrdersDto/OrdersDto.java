package com.senla.controller.dto.OrdersDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto {

    private Integer id;
    private Integer sum = 0;

}
