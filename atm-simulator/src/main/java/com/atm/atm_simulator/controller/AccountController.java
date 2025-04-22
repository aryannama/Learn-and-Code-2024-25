package com.atm.atm_simulator.controller;

import com.atm.atm_simulator.model.Account;
import com.atm.atm_simulator.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
       Account createdAccount =  accountService.createAccount(account);
       return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }
}
