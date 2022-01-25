package com.senla.controller.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateDto {

    private Integer id;
    private String title;
    private Integer price;
    private Integer amount;

}
