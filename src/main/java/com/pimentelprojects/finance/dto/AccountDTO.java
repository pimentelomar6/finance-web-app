package com.pimentelprojects.finance.dto;

import com.pimentelprojects.finance.models.Expense;
import com.pimentelprojects.finance.models.Income;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AccountDTO {

    private Long id;
    private String name;
    private Double balance;
    private List<Income> incomes;
    private List<Expense> expenses;
}
