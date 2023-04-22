package com.pimentelprojects.finance.mapper;


import com.pimentelprojects.finance.dto.AccountDTO;
import com.pimentelprojects.finance.models.Account;


public class AccountMapper {

    public static Account mapToAccount(AccountDTO accountDTO){
        return Account.builder()
                .id(accountDTO.getId())
                .name(accountDTO.getName())
                .balance(accountDTO.getBalance())
                .incomes(accountDTO.getIncomes())
                .expenses(accountDTO.getExpenses())
                .build();
    }

    public static AccountDTO mapToAccountDto(Account account){
        return AccountDTO.builder()
                .id(account.getId())
                .name(account.getName())
                .balance(account.getBalance())
                .incomes(account.getIncomes())
                .expenses(account.getExpenses())
                .build();
    }

}
