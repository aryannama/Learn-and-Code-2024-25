package com.atm.atm_simulator.repository;

import com.atm.atm_simulator.model.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {
    private final Map<String, Account> accounts = new HashMap<>();

    public Account getAccountByNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void createAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }
}
