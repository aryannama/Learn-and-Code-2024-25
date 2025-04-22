package com.atm.atm_simulator.exceptions;

import static com.atm.atm_simulator.constants.ATM.INVALID_PIN_ATTEMPTS_ALLOWED;
import static com.atm.atm_simulator.constants.ExceptionMessages.INVALID_PIN;

public class InvalidPinException extends RuntimeException {
    public InvalidPinException(int attempts) {
        super(String.format(INVALID_PIN, INVALID_PIN_ATTEMPTS_ALLOWED - attempts));
    }
}
