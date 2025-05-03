package com.atm.atm_simulator.service;

import com.atm.atm_simulator.dto.WithdrawResponse;
import com.atm.atm_simulator.exceptions.InsufficientFundsException;
import com.atm.atm_simulator.model.Account;
import com.atm.atm_simulator.model.Card;
import com.atm.atm_simulator.repository.AccountRepository;
import org.springframework.stereotype.Service;

import static com.atm.atm_simulator.constants.ATM.ATM_CASH;
import static com.atm.atm_simulator.constants.ExceptionMessages.INSUFFICIENT_FUNDS_ATM;

@Service
public class ATMService {
    private final CardService cardService;
    private final AccountService accountService;
    private final AccountRepository accountRepository;

    public ATMService(CardService cardService, AccountService accountService, AccountRepository accountRepository) {
        this.cardService = cardService;
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    public WithdrawResponse processWithdrawal(String cardNumber, int pin, double amount) {
        Card card = cardService.validateCardAndPin(cardNumber, pin);
        Account account = accountRepository.getAccountByNumber(card.getAccountNumber());
        accountService.resetDailyWithdrawalIfNewDay(account);

        if (amount > ATM_CASH) {
            throw new InsufficientFundsException(INSUFFICIENT_FUNDS_ATM);
        }
        accountService.withdrawAmount(account, amount);

        return new WithdrawResponse(cardNumber, amount, account.getBalance());
    }
}
