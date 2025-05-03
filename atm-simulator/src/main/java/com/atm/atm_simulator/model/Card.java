package com.atm.atm_simulator.model;

public class Card {
    private String cardNumber;
    private int pin;
    private int invalidPinAttempts;
    private boolean isBlocked;
    private String accountNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getInvalidPinAttempts() {
        return invalidPinAttempts;
    }

    public void setInvalidPinAttempts(int invalidPinAttempts) {
        this.invalidPinAttempts = invalidPinAttempts;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}
