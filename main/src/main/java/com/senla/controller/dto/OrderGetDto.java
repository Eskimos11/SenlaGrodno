package com.senla.controller.dto;

import com.senla.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderGetDto {
    private Integer id;
    private List<ProductDto> productList;
    private Integer sum = 0;

}
