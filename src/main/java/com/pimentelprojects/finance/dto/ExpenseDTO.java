package com.pimentelprojects.finance.dto;

import com.pimentelprojects.finance.models.Account;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ExpenseDTO {
    private Long id;
    private String category;
    private String description;
    private Double amount;
    private Account account;
    private LocalDate date;
}
