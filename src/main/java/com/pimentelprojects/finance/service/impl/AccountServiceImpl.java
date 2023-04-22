package com.pimentelprojects.finance.service.impl;

import com.pimentelprojects.finance.dto.AccountDTO;
import com.pimentelprojects.finance.models.Account;
import com.pimentelprojects.finance.repository.AccountRepository;
import com.pimentelprojects.finance.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.pimentelprojects.finance.mapper.AccountMapper.mapToAccount;
import static com.pimentelprojects.finance.mapper.AccountMapper.mapToAccountDto;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;


    @Override
    public List<AccountDTO> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(a -> mapToAccountDto(a))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDTO getById(Long id) {
        Account account = accountRepository.findById(id).get();
        return mapToAccountDto(account);
    }

    @Override
    public void createAccount(AccountDTO accountDto) {
        accountRepository.save(mapToAccount(accountDto));
    }
}
