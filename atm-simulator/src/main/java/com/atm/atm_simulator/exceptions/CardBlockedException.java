package com.atm.atm_simulator.exceptions;

import static com.atm.atm_simulator.constants.ExceptionMessages.CARD_BLOCKED;

public class CardBlockedException extends RuntimeException{
    public CardBlockedException() {
        super(CARD_BLOCKED);
    }
}
