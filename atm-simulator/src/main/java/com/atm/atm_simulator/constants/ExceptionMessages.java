package com.atm.atm_simulator.constants;

import static com.atm.atm_simulator.constants.ATM.INVALID_PIN_ATTEMPTS_ALLOWED;

public class ExceptionMessages {
    public static final String CARD_BLOCKED = "Card is blocked due to " + INVALID_PIN_ATTEMPTS_ALLOWED + " invalid PIN attempts.";
    public static final String CARD_NOT_FOUND = "Card with number '%s' was not found.";
    public static final String DAILY_LIMIT_EXCEEDED = "Daily withdrawal limit exceeded.";
    public static final String INSUFFICIENT_FUNDS_ACCOUNT = "Insufficient funds in account to process the withdrawal.";
    public static final String INSUFFICIENT_FUNDS_ATM = "Insufficient funds in ATM machine.";
    public static final String INVALID_PIN = "Invalid PIN. Attempts left before blocking: %d";
    public static final String SERVER_UNAVAILABLE = "ATM server is currently unavailable. Please try again later.";
}
