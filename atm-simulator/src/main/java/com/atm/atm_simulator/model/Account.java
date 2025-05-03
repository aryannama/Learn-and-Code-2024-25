package com.atm.atm_simulator.model;

import java.time.LocalDate;

public class Account {
    private String accountNumber;
    private double balance;
    private double dailyLimit;
    private double dailyWithdrawn;
    private LocalDate lastWithdrawalDate;
    private String cardNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(double dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public double getDailyWithdrawn() {
        return dailyWithdrawn;
    }

    public void setDailyWithdrawn(double dailyWithdrawn) {
        this.dailyWithdrawn = dailyWithdrawn;
    }

    public LocalDate getLastWithdrawalDate() {
        return lastWithdrawalDate;
    }

    public void setLastWithdrawalDate(LocalDate lastWithdrawalDate) {
        this.lastWithdrawalDate = lastWithdrawalDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
