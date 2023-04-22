package com.pimentelprojects.finance.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryAmountDTO {
    private String category;
    private Double amount;

}
