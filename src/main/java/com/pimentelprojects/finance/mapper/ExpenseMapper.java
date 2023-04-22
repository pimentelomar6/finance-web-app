package com.pimentelprojects.finance.mapper;

import com.pimentelprojects.finance.dto.ExpenseDTO;
import com.pimentelprojects.finance.dto.IncomeDTO;
import com.pimentelprojects.finance.models.Expense;
import com.pimentelprojects.finance.models.Income;

public class ExpenseMapper {
    public static Expense mapToExpense(ExpenseDTO expenseDTO){
        return Expense.builder()
                .id(expenseDTO.getId())
                .category(expenseDTO.getCategory())
                .description(expenseDTO.getDescription())
                .amount(expenseDTO.getAmount())
                .account(expenseDTO.getAccount())
                .date(expenseDTO.getDate())
                .build();
    }

    public static ExpenseDTO mapToExpenseDto(Expense expense){
        return ExpenseDTO.builder()
                .id(expense.getId())
                .category(expense.getCategory())
                .description(expense.getDescription())
                .amount(expense.getAmount())
                .account(expense.getAccount())
                .date(expense.getDate())
                .build();
    }
}
