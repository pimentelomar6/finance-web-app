package com.pimentelprojects.finance.service.impl;


import com.pimentelprojects.finance.dto.CategoryAmountDTO;
import com.pimentelprojects.finance.dto.ExpenseDTO;
import com.pimentelprojects.finance.mapper.ExpenseMapper;
import com.pimentelprojects.finance.models.Account;
import com.pimentelprojects.finance.models.Expense;
import com.pimentelprojects.finance.repository.ExpenseRepository;
import com.pimentelprojects.finance.service.AccountService;
import com.pimentelprojects.finance.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.pimentelprojects.finance.mapper.AccountMapper.mapToAccountDto;
import static com.pimentelprojects.finance.mapper.ExpenseMapper.mapToExpense;
import static com.pimentelprojects.finance.mapper.ExpenseMapper.mapToExpenseDto;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    private final AccountService accountService;


    @Override
    public List<ExpenseDTO> getAllExpenses() {
        return expenseRepository.findAll()
                .stream()
                .map(ExpenseMapper::mapToExpenseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO getById(Long id) {
        Expense expense = expenseRepository.findById(id).get();
        return  mapToExpenseDto(expense);
    }

    @Override
    public void createExpense(ExpenseDTO expenseDto) {
        Account account = expenseDto.getAccount();
        account.setBalance(account.getBalance() - expenseDto.getAmount());
        accountService.createAccount(mapToAccountDto(account));
        expenseRepository.save(mapToExpense(expenseDto));
    }

    @Override
    public void updateExpense(ExpenseDTO expenseDto) {
        Account account = expenseDto.getAccount();
        Expense expense = expenseRepository.findById(expenseDto.getId()).get();
        account.setBalance(account.getBalance() + expense.getAmount());
        account.setBalance(account.getBalance() - expenseDto.getAmount());
        accountService.createAccount(mapToAccountDto(account));
        expenseRepository.save(mapToExpense(expenseDto));

    }

    @Override
    public void deleteExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id).get();
        Account account = expense.getAccount();
        account.setBalance(account.getBalance() + expense.getAmount());
        accountService.createAccount(mapToAccountDto(account));
        expenseRepository.deleteById(id);
    }

    @Override
    public List<CategoryAmountDTO> categoryAmountList() {
        return expenseRepository.categoryAmountList();
    }
}
