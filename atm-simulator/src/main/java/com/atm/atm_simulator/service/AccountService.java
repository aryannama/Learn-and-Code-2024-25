package com.atm.atm_simulator.service;

import com.atm.atm_simulator.exceptions.DailyLimitExceededException;
import com.atm.atm_simulator.exceptions.InsufficientFundsException;
import com.atm.atm_simulator.model.Account;
import com.atm.atm_simulator.model.Card;
import com.atm.atm_simulator.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.atm.atm_simulator.constants.ExceptionMessages.INSUFFICIENT_FUNDS_ACCOUNT;

@Service
public class AccountService {
    private final CardService cardService;
    private final AccountRepository accountRepository;

    public AccountService(CardService cardService, AccountRepository accountRepository) {
        this.cardService = cardService;
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        Card card = cardService.createCard(account);

        account.setCardNumber(card.getCardNumber());
        accountRepository.createAccount(account);

        return account;
    }

    public void resetDailyWithdrawalIfNewDay(Account account) {
        LocalDate today = LocalDate.now();
        LocalDate lastDate = account.getLastWithdrawalDate();

        if (!today.equals(lastDate)) {
            account.setDailyWithdrawn(0.0);
            account.setLastWithdrawalDate(today);
        }
    }

    public void withdrawAmount(Account account, double amount) {
        if (amount > account.getBalance()) {
            throw new InsufficientFundsException(INSUFFICIENT_FUNDS_ACCOUNT);
        }

        if (account.getDailyWithdrawn() + amount > account.getDailyLimit()) {
            throw new DailyLimitExceededException();
        }

        account.setBalance(account.getBalance() - amount);
        account.setDailyWithdrawn(account.getDailyWithdrawn() + amount);
    }
}

