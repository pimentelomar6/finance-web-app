package com.pimentelprojects.finance.mapper;

import com.pimentelprojects.finance.dto.IncomeDTO;
import com.pimentelprojects.finance.models.Income;

public class IncomeMapper {
    public static Income mapToIncome(IncomeDTO incomeDTO){
        return Income.builder()
                .id(incomeDTO.getId())
                .category(incomeDTO.getCategory())
                .description(incomeDTO.getDescription())
                .amount(incomeDTO.getAmount())
                .account(incomeDTO.getAccount())
                .date(incomeDTO.getDate())
                .build();
    }

    public static IncomeDTO mapToIncomeDto(Income income){
        return IncomeDTO.builder()
                .id(income.getId())
                .category(income.getCategory())
                .description(income.getDescription())
                .amount(income.getAmount())
                .account(income.getAccount())
                .date(income.getDate())
                .build();
    }
}
