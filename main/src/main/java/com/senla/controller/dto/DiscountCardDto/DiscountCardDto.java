package com.senla.controller.dto.DiscountCardDto;

import com.senla.entity.Details;
import com.senla.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCardDto {

    private Long id;
    private String number;
    private Integer balance;
    private Status status;
    private Details details;

}
