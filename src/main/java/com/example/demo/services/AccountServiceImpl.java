package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.example.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void withdrawMoney(BigDecimal amount, long id) {
        Account byId = getAccountOrThrow(id);


        if (byId.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance!");
        }

        BigDecimal newBalance = byId.getBalance().subtract(amount);
        byId.setBalance(newBalance);
        accountRepository.save(byId);

    }

    public void transferMoney(BigDecimal amount, User user, long accountId) {
//        boolean hasAccount = user.getAccounts().stream().anyMatch(a -> a.getId() == accountId);
        Account byId = getAccountOrThrow(accountId);

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cannot transfer negative amount!");
        }


        BigDecimal newBalance = byId.getBalance().subtract(amount);
        byId.setBalance(newBalance);
        accountRepository.save(byId);


    }

    private Account getAccountOrThrow(long id) {
       return accountRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Account with id: " + id + " does not exist!"));
    }


}
