package com.pimentelprojects.finance.service;


import com.pimentelprojects.finance.dto.CategoryAmountDTO;
import com.pimentelprojects.finance.dto.ExpenseDTO;


import java.util.List;

public interface ExpenseService {

    List<ExpenseDTO> getAllExpenses();

    ExpenseDTO getById(Long id);
    void createExpense(ExpenseDTO expense);

    void updateExpense(ExpenseDTO expense);

    void deleteExpenseById(Long id);

    List<CategoryAmountDTO> categoryAmountList();

}
