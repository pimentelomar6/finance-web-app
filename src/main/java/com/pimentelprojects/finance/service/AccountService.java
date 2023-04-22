package com.pimentelprojects.finance.service;

import com.pimentelprojects.finance.dto.AccountDTO;

import java.util.List;


public interface AccountService {

    List<AccountDTO> getAll();

    AccountDTO getById(Long id);
    void createAccount(AccountDTO account);
}
