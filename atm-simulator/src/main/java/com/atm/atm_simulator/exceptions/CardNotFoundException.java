package com.atm.atm_simulator.exceptions;

import static com.atm.atm_simulator.constants.ExceptionMessages.CARD_NOT_FOUND;

public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(String cardNumber) {
        super(String.format(CARD_NOT_FOUND, cardNumber));
    }
}
