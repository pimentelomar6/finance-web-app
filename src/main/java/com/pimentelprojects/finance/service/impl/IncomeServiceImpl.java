package com.pimentelprojects.finance.service.impl;

import com.pimentelprojects.finance.dto.CategoryAmountDTO;
import com.pimentelprojects.finance.dto.IncomeDTO;
import com.pimentelprojects.finance.models.Account;
import com.pimentelprojects.finance.models.Expense;
import com.pimentelprojects.finance.models.Income;
import com.pimentelprojects.finance.repository.IncomeRepository;
import com.pimentelprojects.finance.service.AccountService;
import com.pimentelprojects.finance.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.pimentelprojects.finance.mapper.AccountMapper.mapToAccountDto;
import static com.pimentelprojects.finance.mapper.ExpenseMapper.mapToExpense;
import static com.pimentelprojects.finance.mapper.IncomeMapper.mapToIncome;
import static com.pimentelprojects.finance.mapper.IncomeMapper.mapToIncomeDto;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final AccountService accountService;

    @Override
    public List<IncomeDTO> getAllIncomes() {
        return incomeRepository.findAll().stream()
                .map(i -> mapToIncomeDto(i))
                .collect(Collectors.toList());
    }

    @Override
    public IncomeDTO getById(Long id) {
        Income income = incomeRepository.findById(id).get();
        return mapToIncomeDto(income);
    }

    @Override
    public void createIncome(IncomeDTO incomeDto) {
        Account account = incomeDto.getAccount();
        account.setBalance(account.getBalance() + incomeDto.getAmount());
        accountService.createAccount(mapToAccountDto(account));
        incomeRepository.save(mapToIncome(incomeDto));
    }

    @Override
    public void updateIncome(IncomeDTO incomeDto) {
        Account account = incomeDto.getAccount();
        Income income = incomeRepository.findById(incomeDto.getId()).get();
        account.setBalance(account.getBalance() - income.getAmount());
        account.setBalance(account.getBalance() + incomeDto.getAmount());
        accountService.createAccount(mapToAccountDto(account));
        incomeRepository.save(mapToIncome(incomeDto));
    }

    @Override
    public void deleteById(Long id) {
        Income income = incomeRepository.findById(id).get();
        Account account = income.getAccount();
        account.setBalance(account.getBalance() - income.getAmount());
        accountService.createAccount(mapToAccountDto(account));
        incomeRepository.deleteById(id);
    }

    @Override
    public List<CategoryAmountDTO> categoryAmountList() {
        return incomeRepository.categoryAmountList();
    }
}
