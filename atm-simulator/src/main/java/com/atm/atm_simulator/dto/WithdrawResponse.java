package com.atm.atm_simulator.dto;

public class WithdrawResponse {
    private String cardNumber;
    private double withdrawnAmount;
    private double remainingBalance;

    public WithdrawResponse(String cardNumber, double withdrawnAmount, double remainingBalance) {
        this.cardNumber = cardNumber;
        this.withdrawnAmount = withdrawnAmount;
        this.remainingBalance = remainingBalance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getWithdrawnAmount() {
        return withdrawnAmount;
    }

    public void setWithdrawnAmount(double withdrawnAmount) {
        this.withdrawnAmount = withdrawnAmount;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }
}
